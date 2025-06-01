package com.tomyamn.srm_springboot_backend.repository;

import com.tomyamn.srm_springboot_backend.entity.FormField;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormFieldRepository extends JpaRepository<FormField, Long> {
}
