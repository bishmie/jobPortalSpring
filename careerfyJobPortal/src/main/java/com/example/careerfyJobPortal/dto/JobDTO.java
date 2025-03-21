package com.example.careerfyJobPortal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


    public class JobDTO {
    private Long id;
    private String title;
    private String description;
    @NotBlank(message = "Responsibilities cannot be blank")
    @Size(min = 10, max = 1000, message = "Responsibilities must be between 10 and 1000 characters")
    private String responsibilities;
    @NotBlank(message = "Experiences cannot be blank")
    @Size(min = 10, max = 1000, message = "Experiences must be between 10 and 1000 characters")
    private String experience;
    private String location;
    private String type; // Full-time, Part-time, Remote
    private Double salary;
    private Long companyId;
    private Long employerId;
    private Long jobTypeId;
    private LocalDate postedDate;

        public JobDTO() {
        }

        public JobDTO(Long id, String title, String description, String responsibilities, String experience, String location, String type, Double salary, Long companyId, Long employerId, Long jobTypeId, LocalDate postedDate) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.responsibilities = responsibilities;
            this.experience = experience;
            this.location = location;
            this.type = type;
            this.salary = salary;
            this.companyId = companyId;
            this.employerId = employerId;
            this.jobTypeId = jobTypeId;
            this.postedDate = postedDate;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public @NotBlank(message = "Responsibilities cannot be blank") @Size(min = 10, max = 1000, message = "Responsibilities must be between 10 and 1000 characters") String getResponsibilities() {
            return responsibilities;
        }

        public void setResponsibilities(@NotBlank(message = "Responsibilities cannot be blank") @Size(min = 10, max = 1000, message = "Responsibilities must be between 10 and 1000 characters") String responsibilities) {
            this.responsibilities = responsibilities;
        }

        public @NotBlank(message = "Experiences cannot be blank") @Size(min = 10, max = 1000, message = "Experiences must be between 10 and 1000 characters") String getExperience() {
            return experience;
        }

        public void setExperience(@NotBlank(message = "Experiences cannot be blank") @Size(min = 10, max = 1000, message = "Experiences must be between 10 and 1000 characters") String experience) {
            this.experience = experience;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public Long getCompanyId() {
            return companyId;
        }

        public void setCompanyId(Long companyId) {
            this.companyId = companyId;
        }

        public Long getEmployerId() {
            return employerId;
        }

        public void setEmployerId(Long employerId) {
            this.employerId = employerId;
        }

        public Long getJobTypeId() {
            return jobTypeId;
        }

        public void setJobTypeId(Long jobTypeId) {
            this.jobTypeId = jobTypeId;
        }

        public LocalDate getPostedDate() {
            return postedDate;
        }

        public void setPostedDate(LocalDate postedDate) {
            this.postedDate = postedDate;
        }

        @Override
        public String toString() {
            return "JobDTO{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", responsibilities='" + responsibilities + '\'' +
                    ", experience='" + experience + '\'' +
                    ", location='" + location + '\'' +
                    ", type='" + type + '\'' +
                    ", salary=" + salary +
                    ", companyId=" + companyId +
                    ", employerId=" + employerId +
                    ", jobTypeId=" + jobTypeId +
                    ", postedDate=" + postedDate +
                    '}';
        }
    }

