package com.example.careerfyJobPortal.service;

import com.example.careerfyJobPortal.dto.JobApplicationDTO;
import com.example.careerfyJobPortal.entity.JobApplication;

public interface JobApplicationService {
    JobApplication saveJobApplication(JobApplicationDTO jobApplicationDTO);
}

