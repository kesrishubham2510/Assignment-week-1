package com.grooming.assignment.week2.q2.entity;

import java.time.LocalDate;

import com.grooming.assignment.week2.q2.enums.DOMAIN;
import  com.grooming.assignment.week2.q2.enums.EMPLOYMENT_TYPE;
import  com.grooming.assignment.week2.q2.enums.ROLE;

import  com.grooming.assignment.week2.q2.utilities.ValidationUtility;

import lombok.ToString;

@ToString
public class Employee {

    private static int id;

    static{
        id = 0;
    }

    private String employeeId;
    private String employeeName;
    private LocalDate joiningDate;
    private EMPLOYMENT_TYPE employmentType;
    private ROLE role;
    private DOMAIN domain;

    public Employee(
    String employeeName,
    String joiningDate,
    String employmentType,
    String roleType,
    String domainType){

        setEmployeeId();
        setEmployeeName(employeeName);
        setEmploymentType(employmentType);
        setJoiningDate(joiningDate);
        setRole(roleType);
        setDomain(domainType);

    }

    public void setEmployeeId() {
        this.employeeId = String.valueOf(Employee.getId());

    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = ValidationUtility.validateJoiningDate(joiningDate);
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = ValidationUtility.validateEmploymentType(employmentType);
    }

    public void setRole(String roleType) {
        this.role = ValidationUtility.validateRoleType(roleType);
    }

    public void setDomain(String statusType) {
        this.domain = ValidationUtility.validateStatusType(statusType);
    }
    
    public static int getId(){
        return Employee.id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public EMPLOYMENT_TYPE getEmploymentType() {
        return employmentType;
    }

    public ROLE getRole() {
        return role;
    }

    public DOMAIN getDomain() {
        return domain;
    }


}
