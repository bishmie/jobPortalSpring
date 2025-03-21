package com.example.careerfyJobPortal.service.serviceImpl;

import com.example.careerfyJobPortal.dto.JobApplicationDTO;
import com.example.careerfyJobPortal.entity.Job;
import com.example.careerfyJobPortal.entity.JobApplication;
import com.example.careerfyJobPortal.entity.User;
import com.example.careerfyJobPortal.repositry.JobApplicationRepository;
import com.example.careerfyJobPortal.repositry.JobRepositry;
import com.example.careerfyJobPortal.repositry.UserRepositry;
import com.example.careerfyJobPortal.service.JobApplicationService;
import com.example.careerfyJobPortal.utility.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private JobRepositry jobRepository;

    @Autowired
    private UserRepositry userRepository;

    public JobApplication saveJobApplication(JobApplicationDTO jobApplicationDTO) {
        // Fetch Job and User entities by their IDs
        Job job = jobRepository.findById(jobApplicationDTO.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found"));

        User user = userRepository.findById(Math.toIntExact(jobApplicationDTO.getUserId()))
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Create a new JobApplication entity
        JobApplication jobApplication = new JobApplication();
        jobApplication.setResume(jobApplicationDTO.getResume());
        jobApplication.setStatus(jobApplicationDTO.getStatus());
        jobApplication.setJob(job);
        jobApplication.setUser(user);

        // Save the JobApplication to the database
        return jobApplicationRepository.save(jobApplication);
    }
}
