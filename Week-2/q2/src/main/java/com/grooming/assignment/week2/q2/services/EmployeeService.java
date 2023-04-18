package com.grooming.assignment.week2.q2.services;

import com.grooming.assignment.week2.q2.entity.Employee;
import com.grooming.assignment.week2.q2.repositories.EmployeeRepository;

public class EmployeeService {
    
    private EmployeeRepository employeeRepository;

    public EmployeeService(){
        this.employeeRepository = new EmployeeRepository();
    }

    public void addEmployee(String employeeName, String joiningDate, String employmentType, String roleType, String domainType) throws Exception{
        Employee employee = new Employee(employeeName, joiningDate, employmentType, roleType, domainType);
        employeeRepository.addEmployee(employee);
    }

    public void displayEmployeeDetails(String employeeId) throws Exception{
        System.out.println("displaying employee "+employeeId);
        employeeRepository.displayEmployee(employeeId);
    }

    public void displayAllEmployees() throws Exception{
        employeeRepository.displayEmployees();
    }

    public void getAllEmployees(String roleType) throws Exception{
        System.out.println("All employees having role:- "+roleType);
        employeeRepository.getEmployeeBasedOnRole(roleType).forEach(employee-> {
            try {
                employeeRepository.displayEmployee(employee.getEmployeeId());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }
    
    public void getAllEmployees(long minimumYearsOfExperience) throws Exception{
        System.out.println("All employees having atleast "+minimumYearsOfExperience+" years of experience :- ");
        employeeRepository.getEmployeeBasedOnExperience(minimumYearsOfExperience).forEach(employee-> {
            try {
                employeeRepository.displayEmployee(employee.getEmployeeId());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });;
    }

}
