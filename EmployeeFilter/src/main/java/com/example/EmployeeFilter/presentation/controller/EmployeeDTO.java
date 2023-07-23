package com.example.EmployeeFilter.presentation.controller;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable{

    private String code;
    private String name;
    private Date birthDate;
    private String birthCity;
    private String departmentName;
    private String jobName;
    private String directManagerName;
    private String contractTypeName;
    private Boolean status;
}
