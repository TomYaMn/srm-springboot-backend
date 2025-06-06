package com.tomyamn.srm_springboot_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginUserDto {
    private String email;
    @JsonProperty("username")
    private String userName;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // getters and setters here...
}