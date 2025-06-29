package com.tomyamn.srm_springboot_backend.config;

import com.tomyamn.srm_springboot_backend.auth.CustomAuthenticationProvider;
import com.tomyamn.srm_springboot_backend.filter.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private final CustomAuthenticationProvider customAuthenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfiguration(
            JwtAuthenticationFilter jwtAuthenticationFilter,
            CustomAuthenticationProvider customAuthenticationProvider
    ) {
        this.customAuthenticationProvider = customAuthenticationProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // Allow public access to login and registration endpoints
                        .requestMatchers(HttpMethod.POST, "/api/auth/login", "/api/auth/signup").permitAll()
                        // .requestMatchers(HttpMethod.GET, "/api/auth/me").permitAll()  // Add this line for testing

                        // Protect all other routes
                        .anyRequest().authenticated()
                )
                .authenticationProvider(customAuthenticationProvider) // Use the custom authentication provider
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // Add JWT filter before the username-password authentication filter
                .sessionManagement(session -> session
                        // Set session management to stateless
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .cors(cors -> cors.configurationSource(corsConfigurationSource())); // Enable CORS

        return http.build();
    }

    // Configure CORS to allow frontend requests
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:3001"));  // Your React frontend
        configuration.setAllowedMethods(List.of("GET", "POST", "OPTIONS"));  // Include OPTIONS for CORS preflight
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));  // Allow necessary headers

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
