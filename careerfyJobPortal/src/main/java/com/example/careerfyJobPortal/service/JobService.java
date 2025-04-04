package com.example.careerfyJobPortal.service;

import com.example.careerfyJobPortal.dto.JobDTO;
import com.example.careerfyJobPortal.dto.JobsDto;
import com.example.careerfyJobPortal.entity.Job;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface JobService {

    Job updateJob(Long id, JobDTO jobDTO);

    List<Job> getAllJobs();

    List<JobsDto> getAllForJobCard();

    List<JobsDto> getAllJobsForCards();

    Job getJobById(Long id);

//    Map<String, Object> getJobWithCompany(Long id);

}
