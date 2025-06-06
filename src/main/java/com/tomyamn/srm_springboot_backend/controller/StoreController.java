package com.tomyamn.srm_springboot_backend.controller;

import com.tomyamn.srm_springboot_backend.service.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class StoreController {

    @Autowired
    private MinioService minioService;

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String bucketName = "your-bucket-name";
        String objectName = file.getOriginalFilename();
        String contentType = file.getContentType();

        // minioService.uploadFile(bucketName, objectName, file.getInputStream(), contentType);
    }
}