package com.example.careerfyJobPortal.service;

import com.example.careerfyJobPortal.dto.JobDTO;
import com.example.careerfyJobPortal.dto.JobsDto;
import com.example.careerfyJobPortal.entity.Job;

import java.util.List;
import java.util.Map;

public interface JobService {
    Job saveJob(JobDTO jobDTO);

    Job updateJob(Long id, JobDTO jobDTO);

    List<Job> getAllJobs();

    List<JobsDto> getAllForJobCard();

//    Map<String, Object> getJobWithCompany(Long id);

}
