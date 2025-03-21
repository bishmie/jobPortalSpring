package com.example.careerfyJobPortal.repositry;

import com.example.careerfyJobPortal.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepositry extends JpaRepository<Job, Long> {


}
