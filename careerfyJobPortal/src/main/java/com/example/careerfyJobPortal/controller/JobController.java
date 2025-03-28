package com.example.careerfyJobPortal.controller;

import com.example.careerfyJobPortal.dto.JobDTO;
import com.example.careerfyJobPortal.dto.JobsDto;
import com.example.careerfyJobPortal.dto.ResponseDTO;
import com.example.careerfyJobPortal.entity.Job;
import com.example.careerfyJobPortal.service.JobService;
import com.example.careerfyJobPortal.service.serviceImpl.JobServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jobs")
@Validated
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private JobServiceImpl jobServiceImpl;

    @PostMapping(value = "/add",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ResponseDTO> createJob(
                             @RequestPart("job") @Valid String jobDTO,
                             @RequestPart("files")List<MultipartFile>files) throws JsonProcessingException {
        System.out.println("Received job data: " + jobDTO);


        try{
            ObjectMapper objectMapper = new ObjectMapper();
            JobDTO jobDTO1 = objectMapper.readValue(jobDTO, JobDTO.class);

            int res = jobServiceImpl.saveJob(jobDTO1,files);


        } catch (JsonMappingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();


        }
        return ResponseEntity.status(HttpStatus.CREATED).build();

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
