package com.grooming.assignment.week2.q1.services;

import java.util.List;

import com.grooming.assignment.week2.q1.entity.Employee;
import com.grooming.assignment.week2.q1.repositories.EmployeeRepository;

public class EmployeeService {
    
    private EmployeeRepository employeeRepository;

    public EmployeeService(){
        this.employeeRepository = new EmployeeRepository();
    }

    public void addEmployee(String employeeName, String joiningDate, String employmentType, String roleType, String statusType) throws Exception{
        Employee employee = new Employee(employeeName, joiningDate, employmentType, roleType, statusType);
        employeeRepository.addEmployee(employee);
    }

    public void deleteEmployee(String employeeId) throws Exception{
        employeeRepository.deleteEmployee(employeeId);
    }

    public void updateEmploymentType(String employeeId, String latestEmploymentType) throws Exception{
        employeeRepository.UpdateEmploymentType(employeeId, latestEmploymentType);
    }

    public void updateEmployeeRole(String employeeId, String latestEmployeeRole) throws Exception{
        employeeRepository.UpdateEmploymentType(employeeId, latestEmployeeRole);
    }

    public Employee getSeniorMostEmployee(){
       return employeeRepository.getSeniorMostEmployee();
    }

    public List<Employee> getAllEmployees(String roleType) throws Exception{
        return employeeRepository.getEmployeeBasedOnRole(roleType);
    }





}
