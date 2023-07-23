package com.example.EmployeeFilter.business.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.EmployeeFilter.persistence.dao.ContractTypeRepository;
import com.example.EmployeeFilter.persistence.dao.DepartmentRepository;
import com.example.EmployeeFilter.persistence.dao.EmployeeRepository;
import com.example.EmployeeFilter.persistence.dao.JobRepository;
import com.example.EmployeeFilter.persistence.entities.ContractType;
import com.example.EmployeeFilter.persistence.entities.Department;
import com.example.EmployeeFilter.persistence.entities.Employee;
import com.example.EmployeeFilter.persistence.entities.Job;
import com.example.EmployeeFilter.presentation.controller.EmployeeDTO;

import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private ContractTypeRepository contractTypeRepository;

    public List<EmployeeDTO> findByCriteria(EmployeeDTO searchCriteria) {
        // Fetch department, job, direct manager, and contract type entities based on the provided names
        Department department = searchCriteria.getDepartmentName() != null ? departmentRepository.findByName(searchCriteria.getDepartmentName()) : null;
        Job job = searchCriteria.getJobName() != null ? jobRepository.findByName(searchCriteria.getJobName()) : null;
        Employee directManager = searchCriteria.getDirectManagerName() != null ? employeeRepository.findByName(searchCriteria.getDirectManagerName()) : null;
        ContractType contractType = searchCriteria.getContractTypeName() != null ? contractTypeRepository.findByName(searchCriteria.getContractTypeName()) : null;

        return employeeRepository.findAll((Specification<Employee>) (root, query, criteriaBuilder) -> {
            // Fetch associations eagerly
            root.fetch("department", JoinType.LEFT);
            root.fetch("job", JoinType.LEFT);
            root.fetch("employee", JoinType.LEFT);
            root.fetch("contractType", JoinType.LEFT);

            List<Predicate> predicates = new ArrayList<>();
            if (searchCriteria.getCode() != null) {
                predicates.add(criteriaBuilder.equal(root.get("code"), searchCriteria.getCode()));
            }
            if (searchCriteria.getName() != null) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + searchCriteria.getName() + "%"));
            }
            if (searchCriteria.getBirthDate() != null) {
                predicates.add(criteriaBuilder.equal(root.get("birthDate"), searchCriteria.getBirthDate()));
            }
            if (searchCriteria.getBirthCity() != null) {
                predicates.add(criteriaBuilder.equal(root.get("birthCity"), searchCriteria.getBirthCity()));
            }
            if (department != null) {
                predicates.add(criteriaBuilder.equal(root.get("department"), department));
            }
            if (job != null) {
                predicates.add(criteriaBuilder.equal(root.get("job"), job));
            }
            if (directManager != null) {
                predicates.add(criteriaBuilder.equal(root.get("employee"), directManager));
            }
            if (contractType != null) {
                predicates.add(criteriaBuilder.equal(root.get("contractType"), contractType));
            }
            if (searchCriteria.getStatus() != null) {
                predicates.add(criteriaBuilder.equal(root.get("status"), searchCriteria.getStatus()));
            }

            query.distinct(true); // To avoid duplicate entries if there are multiple results for a search

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }).stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    private EmployeeDTO mapToResponse(Employee employee) {
        EmployeeDTO response = new EmployeeDTO();
        response.setCode(employee.getCode());
        response.setName(employee.getName());
        response.setBirthDate(employee.getBirthDate());
        response.setBirthCity(employee.getBirthCity());
        response.setDepartmentName(employee.getDepartment() != null ? employee.getDepartment().getName() : null);
        response.setJobName(employee.getJob() != null ? employee.getJob().getName() : null);
        response.setDirectManagerName(employee.getEmployee() != null ? employee.getEmployee().getName() : null);
        response.setContractTypeName(employee.getContractType() != null ? employee.getContractType().getName() : null);
        response.setStatus(employee.getStatus());
        return response;
    }
}



// @Service
// public class EmployeeService {

//     @Autowired
//     private EmployeeRepository employeeRepository;
//     @Autowired
//     private DepartmentRepository departmentRepository;
//     @Autowired
//     private JobRepository jobRepository;
//     @Autowired
//     private ContractTypeRepository contractTypeRepository;

//     public List<EmployeeDTO> findByCriteria(String code, String name, LocalDate birthDate, String birthCity,
//                                                        String departmentName, String jobName, String directManagerName,
//                                                        String contractTypeName, Boolean status) {

//         // Fetch department, job, direct manager, and contract type entities based on the provided names
//         Department department = departmentName != null ? departmentRepository.findByName(departmentName) : null;
//         Job job = jobName != null ? jobRepository.findByName(jobName) : null;
//         Employee directManager = directManagerName != null ? employeeRepository.findByName(directManagerName) : null;
//         ContractType contractType = contractTypeName != null ? contractTypeRepository.findByName(contractTypeName) : null;

//         return employeeRepository.findAll((Specification<Employee>) (root, query, criteriaBuilder) -> {
//             // Fetch associations eagerly
//             root.fetch("department", JoinType.LEFT);
//             root.fetch("job", JoinType.LEFT);
//             root.fetch("employee", JoinType.LEFT);
//             root.fetch("contractType", JoinType.LEFT);

//             List<Predicate> predicates = new ArrayList<>();
//             if (code != null) {
//                 predicates.add(criteriaBuilder.equal(root.get("code"), code));
//             }
//             if (name != null) {
//                 predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
//             }
//             if (birthDate != null) {
//                 predicates.add(criteriaBuilder.equal(root.get("birthDate"), birthDate));
//             }
//             if (birthCity != null) {
//                 predicates.add(criteriaBuilder.equal(root.get("birthCity"), birthCity));
//             }
//             if (department != null) {
//                 predicates.add(criteriaBuilder.equal(root.get("department"), department));
//             }
//             if (job != null) {
//                 predicates.add(criteriaBuilder.equal(root.get("job"), job));
//             }
//             if (directManager != null) {
//                 predicates.add(criteriaBuilder.equal(root.get("employee"), directManager));
//             }
//             if (contractType != null) {
//                 predicates.add(criteriaBuilder.equal(root.get("contractType"), contractType));
//             }
//             if (status != null) {
//                 predicates.add(criteriaBuilder.equal(root.get("status"), status));
//             }

//             query.distinct(true); // To avoid duplicate entries if there are multiple results for a search

//             return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//         }).stream().map(this::mapToResponse).collect(Collectors.toList());
//     }

//     private EmployeeDTO mapToResponse(Employee employee) {
//         EmployeeDTO response = new EmployeeDTO();
//         response.setCode(employee.getCode());
//         response.setName(employee.getName());
//         response.setBirthDate(employee.getBirthDate());
//         response.setBirthCity(employee.getBirthCity());
//         response.setDepartmentName(employee.getDepartment() != null ? employee.getDepartment().getName() : null);
//         response.setJobName(employee.getJob() != null ? employee.getJob().getName() : null);
//         response.setDirectManagerName(employee.getEmployee() != null ? employee.getEmployee().getName() : null);
//         response.setContractTypeName(employee.getContractType() != null ? employee.getContractType().getName() : null);
//         response.setStatus(employee.getStatus());
//         return response;
//     }
// }