package com.grooming.assignment.week2.q2.services;

import java.util.List;

import com.grooming.assignment.week2.q2.entity.Employee;
import com.grooming.assignment.week2.q2.repositories.EmployeeRepository;

public class EmployeeService {
    
    private EmployeeRepository employeeRepository;

    public EmployeeService(){
        this.employeeRepository = new EmployeeRepository();
    }

    public void addEmployee(String employeeName, String joiningDate, String employmentType, String roleType, String statusType) throws Exception{
        Employee employee = new Employee(employeeName, joiningDate, employmentType, roleType, statusType);
        employeeRepository.addEmployee(employee);
    }

    public void displayEmployeeDetails(String employeeId) throws Exception{
       employeeRepository.displayEmployee(employeeId);
    }

    public List<Employee> getAllEmployees(String roleType) throws Exception{
        return employeeRepository.getEmployeeBasedOnRole(roleType);
    }

    public List<Employee> getAllEmployees(long minimumYearsOfExperience) throws Exception{
       return employeeRepository.getEmployeeBasedOnExperience(minimumYearsOfExperience);
    }

}
