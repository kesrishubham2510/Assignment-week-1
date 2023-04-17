package com.grooming.assignment.week2.q1.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.grooming.assignment.week2.q1.entity.Employee;
import com.grooming.assignment.week2.q1.enums.ROLE;
import com.grooming.assignment.week2.q1.exceptions.EmployeeNotFoundException;
import com.grooming.assignment.week2.q1.utilities.EmployeeSorter;
import com.grooming.assignment.week2.q1.utilities.ValidationUtility;

public class EmployeeRepository {

    Set<String> ids;
    List<Employee> employees;

    public EmployeeRepository(){
         ids = new HashSet<>();
         employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) throws Exception{
        if(employees==null)
         throw new Exception("The employee list is not instantiated");
         
         this.employees.add(employee);
         this.ids.add(employee.getEmployeeId());
    }
        
    public void deleteEmployee(String employeeId) throws Exception{
         
        if(employees==null)
         throw new Exception("The employee list is not instantiated");
        
        if(ids.contains(employeeId)){
            employees.removeIf(employee-> employee.getEmployeeId() == employeeId);
            System.out.println("Employee with id:- "+employeeId+" has been successfully deleted");
        }
        else
         System.out.println("No employee with Id:-"+employeeId+" was found in the system");  
    }
    
    public void UpdateEmploymentType(String employeeId, String employemmentType) throws Exception{
        if(employees==null)
         throw new Exception("The employee list is not instantiated");
        
        if(ids.contains(employeeId)){
            Employee existingEmployee = employees.stream().filter(employee-> employee.getEmployeeId()==employeeId).findFirst().get();
            existingEmployee.setEmploymentType(employemmentType);
            System.out.println("Employment of employee with id:- "+employeeId+" has been successfully updated");
        }
        else
         System.out.println("No employee with Id:-"+employeeId+" was found in the system");  
        
        
    }

    public void UpdateRoleType(String employeeId, String roleType) throws Exception{
        if(employees==null)
         throw new Exception("The employee list is not instantiated");
        
        if(ids.contains(employeeId)){
            Employee existingEmployee = employees.stream().filter(employee-> employee.getEmployeeId()==employeeId).findFirst().get();
            existingEmployee.setRole(roleType);
            System.out.println("Role of employee with id:- "+employeeId+" has been successfully updated");
        }
        else
         System.out.println("No employee with Id:-"+employeeId+" was found in the system");      
    }

    public List<Employee> getEmployeeBasedOnRole(String roleType) throws Exception{
        if(employees==null)
         throw new Exception("The employee list is not instantiated");
      
         ROLE filterRole = ValidationUtility.validateRoleType(roleType);

         return employees.stream().filter(employee-> employee.getRole() == filterRole).collect(Collectors.toList());
    }

    public Employee getSeniorMostEmployee(){

        if(ids.isEmpty())
         throw new EmployeeNotFoundException("!! There are no employees currently !!");
        
        Collections.sort(employees, new EmployeeSorter());
        
        return employees.get(0);
    }
}
