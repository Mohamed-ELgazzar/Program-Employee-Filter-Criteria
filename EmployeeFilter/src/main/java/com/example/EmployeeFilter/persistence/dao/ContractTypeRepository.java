package com.example.EmployeeFilter.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeFilter.persistence.entities.ContractType;

@Repository
public interface ContractTypeRepository extends JpaRepository<ContractType, Long> {
    
    ContractType findByName(String name);
    
}