package com.example.EmployeeFilter.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * ContractType generated by hbm2java
 */
@Entity
@Table(name = "contract_type")
public class ContractType implements java.io.Serializable {

    private Long id;
    private String name;
    private Set<Employee> employees = new HashSet<Employee>(0);

    public ContractType() {
    }

    public ContractType(String name) {
        this.name = name;
    }

    public ContractType(String name, Set<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "contractType")
    @JsonIgnore
    public Set<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

}
