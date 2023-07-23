package com.example.EmployeeFilter.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeFilter.persistence.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
        Department findByName(String name);
    
}