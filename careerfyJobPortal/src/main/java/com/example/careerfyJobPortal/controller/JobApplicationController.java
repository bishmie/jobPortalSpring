package com.example.careerfyJobPortal.controller;

import com.example.careerfyJobPortal.dto.JobApplicationDTO;
import com.example.careerfyJobPortal.entity.JobApplication;
import com.example.careerfyJobPortal.service.JobApplicationService;
import org.apache.tomcat.util.http.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job-applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/add")
    public JobApplication createJobApplication(@RequestBody JobApplicationDTO jobApplicationDTO) {
        return jobApplicationService.saveJobApplication(jobApplicationDTO);
    }


    @PostMapping("/update-status")
    public JobApplication updateJobApplicationStatus(@RequestBody JobApplicationDTO jobApplicationDTO) {
        return jobApplicationService.saveJobApplication(jobApplicationDTO);
    }
}
