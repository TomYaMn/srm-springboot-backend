package com.tomyamn.srm_springboot_backend.repository;

import com.tomyamn.srm_springboot_backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String name); // Custom query to find a role by its name
}
