package com.example.careerfyJobPortal.service;

import com.example.careerfyJobPortal.dto.JobDTO;
import com.example.careerfyJobPortal.entity.Job;

import java.util.List;

public interface JobService {
    Job saveJob(JobDTO jobDTO);

    Job updateJob(Long id, JobDTO jobDTO);

    List<Job> getAllJobs();
}
