package com.example.EmployeeFilter.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeFilter.persistence.entities.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    
    Job findByName(String name);
    
}