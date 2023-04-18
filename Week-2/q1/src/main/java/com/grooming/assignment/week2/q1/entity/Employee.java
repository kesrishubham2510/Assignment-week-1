package com.grooming.assignment.week2.q1.entity;

import java.time.LocalDate;

import com.grooming.assignment.week2.q1.enums.EMPLOYMENT_TYPE;
import com.grooming.assignment.week2.q1.enums.ROLE;
import com.grooming.assignment.week2.q1.enums.STATUS;
import com.grooming.assignment.week2.q1.utilities.ValidationUtility;

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
    private STATUS status;

    public Employee(
    String employeeName,
    String joiningDate,
    String employmentType,
    String roleType,
    String statusType){

        setEmployeeId();
        setEmployeeName(employeeName);
        setEmploymentType(employmentType);
        setJoiningDate(joiningDate);
        setRole(roleType);
        setStatus(statusType);

    }

    public void setEmployeeId() {
        this.employeeId = String.valueOf(Employee.getId());
        Employee.id++;
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

    public void setStatus(String statusType) {
        this.status = ValidationUtility.validateStatusType(statusType);
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

    public STATUS getStatus() {
        return status;
    }
}
