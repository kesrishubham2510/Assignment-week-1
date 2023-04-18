package com.grooming.assignment.week2.q2.drivers;

import com.grooming.assignment.week2.q2.entity.Employee;

public class InputTestDriver {
    public String testInput(String name, String dateOfJoininig, String employmentType, String roleType, String domainType){
        String message = "Successfully Processed";
        try {
            Employee employee = new Employee(name, dateOfJoininig, employmentType, roleType, domainType);
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        return message;
    } 
}
