package com.tomyamn.srm_springboot_backend.repository;

import com.tomyamn.srm_springboot_backend.entity.FormFieldDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormFieldDocumentRepository extends JpaRepository<FormFieldDocument, Long> {
}
