package com.example.careerfyJobPortal.service.serviceImpl;

import com.example.careerfyJobPortal.dto.JobDTO;
import com.example.careerfyJobPortal.dto.JobsDto;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

//    public Job saveJob(JobDTO jobDTO) {
//        Job job = new Job();
//        job.setTitle(jobDTO.getTitle());
//        job.setDescription(jobDTO.getDescription());
//        job.setResponsibilities(jobDTO.getResponsibilities());
//        job.setExperience(jobDTO.getExperience());
//        job.setLocation(jobDTO.getLocation());
//        job.setType(jobDTO.getType());
//        job.setSalary(jobDTO.getSalary());
//        job.setDeadline(jobDTO.getDeadline());
//        job.setCompanyName(jobDTO.getCompanyName());
//        jobDTO.setEmail(job.getEmail());
//        jobDTO.setCompanyDescription(job.getCompanyDescription());
//        jobDTO.setLogo(job.getLogo());
//
////        Company company = companyRepository.findById(Math.toIntExact(jobDTO.getCompanyId())).orElse(null);
//        User employer = userRepository.findById(Math.toIntExact(jobDTO.getEmployerId())).orElse(null);
//        JobType jobType = jobTypeRepository.findById(jobDTO.getJobTypeId()).orElse(null);
//
////        job.setCompany(company);
//        job.setEmployer(employer);
//        job.setJobType(jobType);
//
//        return jobRepository.save(job);
//    }


    public Job saveJob(JobDTO jobDTO) {
        Job job = new Job();
        job.setTitle(jobDTO.getTitle());
        job.setDescription(jobDTO.getDescription());
        job.setResponsibilities(jobDTO.getResponsibilities());
        job.setExperience(jobDTO.getExperience());
        job.setLocation(jobDTO.getLocation());
        job.setType(jobDTO.getType());
        job.setSalary(jobDTO.getSalary());
        job.setDeadline(jobDTO.getDeadline());
        job.setCompanyName(jobDTO.getCompanyName());
        job.setEmail(jobDTO.getEmail());
        job.setCompanyDescription(jobDTO.getCompanyDescription());
        job.setLogo(jobDTO.getLogo());

        // Set JobType from DTO
        JobType jobType = jobTypeRepository.findById(jobDTO.getJobTypeId())
                .orElseThrow(() -> new RuntimeException("Job type not found"));
        job.setJobType(jobType);

        // Set Employer from DTO
        User employer = userRepository.findById(jobDTO.getEmployerId())
                .orElseThrow(() -> new RuntimeException("Employer not found"));
        job.setEmployer(employer);

        System.out.println("Saving job to database: " + job);
        // Save Job to Database
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
        existingJob.setDeadline(jobDTO.getDeadline());
        existingJob.setCompanyName(jobDTO.getCompanyName());
        existingJob.setEmail(jobDTO.getEmail());
        existingJob.setCompanyDescription(jobDTO.getCompanyDescription());
        existingJob.setLogo(jobDTO.getLogo());


//        Company company = companyRepository.findById(Math.toIntExact(jobDTO.getCompanyId())).orElse(null);
        User employer = userRepository.findById(Math.toIntExact(jobDTO.getEmployerId())).orElse(null);
        JobType jobType = jobTypeRepository.findById(jobDTO.getJobTypeId()).orElse(null);

//        existingJob.setCompany(company);
        existingJob.setEmployer(employer);
        existingJob.setJobType(jobType);

        return jobRepository.save(existingJob);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public List<JobsDto> getAllForJobCard() {
        return jobRepository.findAll()
                .stream()
                .map(job -> new JobsDto(job.getTitle(), job.getDescription(),
                        job.getLocation(),
                        job.getType(),
                        job.getCompanyName(),
                        job.getLogo()))
                .collect(Collectors.toList());
    }


//    public Map<String, Object> getJobWithCompany(Long id) {
//        Optional<Job> jobOptional = jobRepository.findById(id);
//        if (jobOptional.isPresent()) {
//            Job job = jobOptional.get();
//            Map<String, Object> response = new HashMap<>();
//            response.put("job", job);
//
//            Map<String, Object> companyData = new HashMap<>();
//            companyData.put("name", job.getCompany().getName());
//            companyData.put("logo", job.getCompany().getLogo()); // Logo URL eka
//
//            response.put("company", companyData);
//            return response;
//        } else {
//            return null; // Job not found
//        }
//    }




}
