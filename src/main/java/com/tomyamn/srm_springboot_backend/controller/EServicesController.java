package com.tomyamn.srm_springboot_backend.controller;

import com.tomyamn.srm_springboot_backend.dto.EServiceDto;
import com.tomyamn.srm_springboot_backend.service.EServiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class EServicesController {

    private final EServiceService EServiceService;

    public EServicesController(EServiceService EServiceService) {
        this.EServiceService = EServiceService;
    }

    @GetMapping
    public List<EServiceDto> getAllServices() {
        return EServiceService.getAllServices();
    }

    @GetMapping("/{category}")
    public EServiceDto getServiceByCategory(@PathVariable String category) {
        return EServiceService.getServiceByCategory(category);
    }
}
