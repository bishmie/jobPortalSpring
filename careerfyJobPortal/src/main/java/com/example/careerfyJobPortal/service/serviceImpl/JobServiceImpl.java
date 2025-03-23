package com.example.careerfyJobPortal.service.serviceImpl;

import com.example.careerfyJobPortal.dto.JobDTO;
import com.example.careerfyJobPortal.entity.Company;
import com.example.careerfyJobPortal.entity.Job;
import com.example.careerfyJobPortal.entity.JobType;
import com.example.careerfyJobPortal.entity.User;

import com.example.careerfyJobPortal.repositry.ComapanyReposity;
import com.example.careerfyJobPortal.repositry.JobRepositry;
import com.example.careerfyJobPortal.repositry.JobTypeRepository;
import com.example.careerfyJobPortal.repositry.UserRepositry;
import com.example.careerfyJobPortal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        job.setDeadline(jobDTO.getPostedDate());

        Company company = companyRepository.findById(Math.toIntExact(jobDTO.getCompanyId())).orElse(null);
        User employer = userRepository.findById(Math.toIntExact(jobDTO.getEmployerId())).orElse(null);
        JobType jobType = jobTypeRepository.findById(jobDTO.getJobTypeId()).orElse(null);

        job.setCompany(company);
        job.setEmployer(employer);
        job.setJobType(jobType);

        return jobRepository.save(job);
    }

    @Override
    public Job updateJob(Long id, JobDTO jobDTO) {
        Job existingJob = jobRepository.findById(id).orElse(null);

        if (existingJob == null) {
            return null;
        }

        // Update job properties
        existingJob.setTitle(jobDTO.getTitle());
        existingJob.setDescription(jobDTO.getDescription());
        existingJob.setResponsibilities(jobDTO.getResponsibilities());
        existingJob.setExperience(jobDTO.getExperience());
        existingJob.setLocation(jobDTO.getLocation());
        existingJob.setType(jobDTO.getType());
        existingJob.setSalary(jobDTO.getSalary());
        existingJob.setDeadline(jobDTO.getPostedDate());

        Company company = companyRepository.findById(Math.toIntExact(jobDTO.getCompanyId())).orElse(null);
        User employer = userRepository.findById(Math.toIntExact(jobDTO.getEmployerId())).orElse(null);
        JobType jobType = jobTypeRepository.findById(jobDTO.getJobTypeId()).orElse(null);

        existingJob.setCompany(company);
        existingJob.setEmployer(employer);
        existingJob.setJobType(jobType);

        return jobRepository.save(existingJob);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }


}
