package com.grooming.assignment.week1.q1.drivers;

import com.grooming.assignment.week1.q1.entity.JobApplicant;
import com.grooming.assignment.week1.q1.messages.Message;

public class TestInput {
   
    public String testInput(String techStack, float yearsOfExperience, String currentPackage){

        String message = "";

        try {         
            JobApplicant jobApplicant = new JobApplicant(techStack, yearsOfExperience,currentPackage);
            message = Message.getExpectedSalaryMessage(jobApplicant.getTechStack(), jobApplicant.getCurrentPackage());
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        return message;
    }
    
}
