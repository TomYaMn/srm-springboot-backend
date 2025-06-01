package com.tomyamn.srm_springboot_backend.controller;

import com.tomyamn.srm_springboot_backend.dto.SubmissionRequestDto;
import com.tomyamn.srm_springboot_backend.entity.Submission;
import com.tomyamn.srm_springboot_backend.service.SubmissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/submissions")
@CrossOrigin(origins = "*") // Optional: Allow cross-origin requests
public class SubmissionController {
    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE) // Accept multipart data
    public ResponseEntity<Submission> createSubmission(@ModelAttribute SubmissionRequestDto submissionRequestDto) {
        Submission savedSubmission = submissionService.saveSubmission(submissionRequestDto);
        return ResponseEntity.ok(savedSubmission);
    }
}
