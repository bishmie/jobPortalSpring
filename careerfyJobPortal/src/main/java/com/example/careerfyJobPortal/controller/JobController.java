package com.example.careerfyJobPortal.controller;

import com.example.careerfyJobPortal.dto.JobDTO;
import com.example.careerfyJobPortal.entity.Job;
import com.example.careerfyJobPortal.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
