package com.example.careerfyJobPortal.controller;

import com.example.careerfyJobPortal.dto.JobDTO;
import com.example.careerfyJobPortal.dto.JobsDto;
import com.example.careerfyJobPortal.entity.Job;
import com.example.careerfyJobPortal.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jobs")
@Validated
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/add")
    public Job createJob(@Valid @RequestBody JobDTO jobDTO) {
        return jobService.saveJob(jobDTO);

    }


    @PutMapping("/update/{id}")
    public Job updateJob(@PathVariable Long id, @RequestBody JobDTO jobDTO) {
        return jobService.updateJob(id, jobDTO);
    }


    @GetMapping("/getAll")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }


//    @GetMapping("/getAllForJobCards/{id}")
//    public ResponseEntity<?> getJobWithCompany(@PathVariable Long id) {
//        Map<String, Object> response = jobService.getJobWithCompany(id);
//
//        if (response != null) {
//            return ResponseEntity.ok(response);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job Not Found");
//        }
//    }


    @GetMapping("/getAllForJobCards")
    public List<JobsDto> getAllJobsAttr() {
        // Return the list of JobDTOs containing only title and responsibilities
        return jobService.getAllForJobCard();
    }

}
