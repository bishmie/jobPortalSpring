package com.example.careerfyJobPortal.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description; // Job Description

    @Lob
    private String responsibilities; // Key Responsibilities

    @Lob
    private String experience; // Experience needed

    private String location;
    private String type; // Full-time, Part-time, Remote
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private User employer;

    @ManyToOne
    @JoinColumn(name = "job_type_id")
    private JobType jobType;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    private List<JobApplication> applications;

    private LocalDate deadline;

    public Job() {
    }


    public Job(Long id, String title, String description, String responsibilities, String experience, String location, String type, Double salary, Company company, User employer, JobType jobType, List<JobApplication> applications, LocalDate deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.responsibilities = responsibilities;
        this.experience = experience;
        this.location = location;
        this.type = type;
        this.salary = salary;
        this.company = company;
        this.employer = employer;
        this.jobType = jobType;
        this.applications = applications;
        this.deadline = deadline;
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

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getEmployer() {
        return employer;
    }

    public void setEmployer(User employer) {
        this.employer = employer;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public List<JobApplication> getApplications() {
        return applications;
    }

    public void setApplications(List<JobApplication> applications) {
        this.applications = applications;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", responsibilities='" + responsibilities + '\'' +
                ", experience='" + experience + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", salary=" + salary +
                ", company=" + company +
                ", employer=" + employer +
                ", jobType=" + jobType +
                ", applications=" + applications +
                ", deadline=" + deadline +
                '}';
    }
}


