package com.grooming.assignment.week1.q1.drivers;

import com.grooming.assignment.week1.q1.entity.JobApplicant;
import com.grooming.assignment.week1.q1.messages.Message;

public class TestInput {
   
    public String displayMessage(String firstName, String lastName, String techStack, float yearsOfExperience, String currentPackage){

        String message = "";

        try {         
            JobApplicant jobApplicant = new JobApplicant(firstName, lastName, techStack, yearsOfExperience,currentPackage);
            message = Message.getExpectedSalaryMessage(jobApplicant.getTechStack(), jobApplicant.getCurrentPackage());
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        return message;
    }
    
}
