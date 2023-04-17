package com.grooming.assignment.week2.q1.drivers;

import com.grooming.assignment.week2.q1.entity.Employee;

public class InputTestDriver {
    public String testInput(String name, String dateOfJoininig, String employmentType, String roleType, String statusType){
        String message = "Successfully Processed";
        try {
            Employee employee = new Employee(name, dateOfJoininig, employmentType, roleType, statusType);
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        return message;
    }
}
