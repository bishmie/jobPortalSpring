package com.example.careerfyJobPortal.controller;

import com.example.careerfyJobPortal.dto.JobDTO;
import com.example.careerfyJobPortal.dto.JobsDto;
import com.example.careerfyJobPortal.dto.ResponseDTO;
import com.example.careerfyJobPortal.entity.Job;
import com.example.careerfyJobPortal.service.JobService;
import com.example.careerfyJobPortal.service.serviceImpl.JobServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
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

    @PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ResponseDTO> createJob(
            @RequestPart("job") @Valid String jobDTO,
            @RequestPart("files") List<MultipartFile> files) {

        try {
            System.out.println("Raw JSON received: " + jobDTO);

            System.out.println("Files received: "+ files);

            ObjectMapper objectMapper = new ObjectMapper();
            // Configure to fail on unknown properties
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JobDTO jobDTO1 = objectMapper.readValue(jobDTO, JobDTO.class);
            System.out.println("Successfully parsed to DTO: " + jobDTO1);

            int res = jobServiceImpl.saveJob(jobDTO1, files);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (JsonMappingException e) {
            System.err.println("JSON Mapping Error: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO(400, "Invalid JSON structure: " + e.getMessage()));

        } catch (JsonProcessingException e) {
            System.err.println("JSON Processing Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO(400, "JSON processing error"));

        } catch (Exception e) {
            System.err.println("General Error: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.internalServerError()
                    .body(new ResponseDTO(500, "Server error"));
        }
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


    public List<JobsDto> getAllJobsAttr() {
        // Return the list of JobDTOs containing only title and responsibilities
        return jobService.getAllForJobCard();
    }

    @GetMapping("/getAllForJobCards")
    public ResponseEntity<List<JobsDto>> getAllJobsForCards() {
        return ResponseEntity.ok(jobService.getAllJobsForCards());
    }


    @GetMapping("getJobsById/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job jobDetails = jobService.getJobById(id);
        return jobDetails != null ? ResponseEntity.ok(jobDetails) : ResponseEntity.notFound().build();
    }

}
