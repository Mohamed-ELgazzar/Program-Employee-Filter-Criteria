package com.example.EmployeeFilter.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.EmployeeFilter.business.Services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/search")
    public List<EmployeeDTO> search(@RequestBody EmployeeDTO searchCriteria) {
        return employeeService.findByCriteria(searchCriteria);
    }
}

// @GetMapping("/search")
//     public List<EmployeeDTO> search(
//             @RequestParam(required = false) String code,
//             @RequestParam(required = false) String name,
//             @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate,
//             @RequestParam(required = false) String birthCity,
//             @RequestParam(required = false) String department, // Change to String type
//             @RequestParam(required = false) String job, // Change to String type
//             @RequestParam(required = false) String directManager, // Change to String type
//             @RequestParam(required = false) String contractType, // Change to String type
//             @RequestParam(required = false) Boolean status
//     ) {
//         return employeeService.findByCriteria(code, name, birthDate, birthCity, department, job, directManager, contractType, status);
//     }