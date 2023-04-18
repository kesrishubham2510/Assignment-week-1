package com.grooming.assignment.week2.q1.utilities;



import java.util.Comparator;

import com.grooming.assignment.week2.q1.entity.Employee;

public class EmployeeSorter implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
         if(employee1.getJoiningDate().isBefore(employee2.getJoiningDate()))
           return -1;
         else if(employee1.getJoiningDate()==employee2.getJoiningDate())
          return 0;
         return 1;
    }
}
