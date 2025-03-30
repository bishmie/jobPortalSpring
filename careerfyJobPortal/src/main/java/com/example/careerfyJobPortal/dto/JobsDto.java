package com.example.careerfyJobPortal.dto;

import com.example.careerfyJobPortal.entity.Job;

public class JobsDto {
    private String title;

    private String description;
    private String location;
    private String type;
    private String salary;
    private String companyName;
    private String logo;

    public JobsDto() {
    }

    public JobsDto(String title, String description, String location, String type, String salary, String companyName, String logo) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.salary = salary;
        this.companyName = companyName;
        this.logo = logo;
    }

    public JobsDto(Job job) {

        this.title = job.getTitle();
        this.description = job.getDescription();
        this.companyName = job.getCompanyName();
        this.location = job.getLocation();
        this.type = job.getType();
        this.salary=job.getSalary();
        this.logo = job.getLogo();
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {

        this.logo = logo;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "JobsDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", salary='" + salary + '\'' +
                ", companyName='" + companyName + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}

