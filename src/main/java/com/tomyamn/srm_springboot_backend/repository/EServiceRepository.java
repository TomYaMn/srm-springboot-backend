package com.tomyamn.srm_springboot_backend.repository;

import com.tomyamn.srm_springboot_backend.entity.EService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EServiceRepository extends JpaRepository<EService, Long> {
    EService findByEServiceName(String category);
}
