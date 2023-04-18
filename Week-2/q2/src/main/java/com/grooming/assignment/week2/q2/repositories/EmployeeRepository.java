package com.grooming.assignment.week2.q2.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.grooming.assignment.week2.q2.entity.Employee;
import com.grooming.assignment.week2.q2.enums.ROLE;
import com.grooming.assignment.week2.q2.exceptions.EmployeeNotFoundException;
import com.grooming.assignment.week2.q2.utilities.ValidationUtility;

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

    public void displayEmployee(String employeeId) throws Exception{
        if(employees==null)
         throw new Exception("The employee list is not instantiated");

        if(ids.contains(employeeId))
         System.out.println(employees.stream().filter(employee-> employee.getEmployeeId() == employeeId).findFirst().get()); 
        else 
         throw new EmployeeNotFoundException("No employee with Id:-"+employeeId+" was found in the system");
          
    }
    
    public List<Employee> getEmployeeBasedOnRole(String roleType) throws Exception{
        if(employees==null)
         throw new Exception("The employee list is not instantiated");
      
         ROLE filterRole = ValidationUtility.validateRoleType(roleType);

         return employees.stream().filter(employee-> employee.getRole() == filterRole).collect(Collectors.toList());
    }
    
    public List<Employee> getEmployeeBasedOnExperience(long minimumExperience) throws Exception{
        if(employees==null)
         throw new Exception("The employee list is not instantiated");
        
        Predicate<Employee> filterCondition = (employee)-> employee.getJoiningDate().isBefore(LocalDate.now().minusYears(minimumExperience));
         
        return employees.stream().filter(filterCondition).collect(Collectors.toList());
    }

  
}
