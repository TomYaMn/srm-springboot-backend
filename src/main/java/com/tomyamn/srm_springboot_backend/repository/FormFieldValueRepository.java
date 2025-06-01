package com.tomyamn.srm_springboot_backend.repository;

import com.tomyamn.srm_springboot_backend.entity.FormFieldValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormFieldValueRepository extends JpaRepository<FormFieldValue, Long> {
}