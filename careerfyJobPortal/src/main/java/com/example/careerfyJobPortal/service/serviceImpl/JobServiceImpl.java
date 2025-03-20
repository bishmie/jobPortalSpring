package com.example.careerfyJobPortal.service;

import com.example.careerfyJobPortal.dto.JobDTO;
import com.example.careerfyJobPortal.entity.Company;
import com.example.careerfyJobPortal.entity.Job;
import com.example.careerfyJobPortal.entity.JobType;
import com.example.careerfyJobPortal.entity.User;

import com.example.careerfyJobPortal.repositry.ComapanyReposity;
import com.example.careerfyJobPortal.repositry.JobRepositry;
import com.example.careerfyJobPortal.repositry.JobTypeRepository;
import com.example.careerfyJobPortal.repositry.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepositry jobRepository;

    @Autowired
    private ComapanyReposity companyRepository;

    @Autowired
    private UserRepositry userRepository;

    @Autowired
    private JobTypeRepository jobTypeRepository;

    public Job saveJob(JobDTO jobDTO) {
        Job job = new Job();
        job.setTitle(jobDTO.getTitle());
        job.setDescription(jobDTO.getDescription());
        job.setResponsibilities(jobDTO.getResponsibilities());
        job.setExperience(jobDTO.getExperience());
        job.setLocation(jobDTO.getLocation());
        job.setType(jobDTO.getType());
        job.setSalary(jobDTO.getSalary());
        job.setPostedDate(jobDTO.getPostedDate());

        // Set Company, Employer, and JobType
        Company company = companyRepository.findById(Math.toIntExact(jobDTO.getCompanyId())).orElse(null);
        User employer = userRepository.findById(jobDTO.getEmployerId()).orElse(null);
        JobType jobType = jobTypeRepository.findById(jobDTO.getJobTypeId()).orElse(null);

        job.setCompany(company);
        job.setEmployer(employer);
        job.setJobType(jobType);

        return jobRepository.save(job);
    }
}
