package com.grooming.assignment.week1.q1.drivers;

import java.util.Scanner;

import com.grooming.assignment.week1.q1.entity.JobApplicant;
import com.grooming.assignment.week1.q1.messages.Message;

public class IdealCaseDriver {

    public static void main(String[] args) {
        
        Scanner scannerObj = new Scanner(System.in);
            
        String techStack,currentPackage;
        float yearsOfExperience;
    
        System.out.println("Please Enter your tech stack");
        techStack = scannerObj.nextLine();
        System.out.println("Please Enter your current package");
        currentPackage = scannerObj.nextLine(); 
        System.out.println("Please Enter your years of experience");
        yearsOfExperience = scannerObj.nextFloat();

        
        try {
          
            JobApplicant jobApplicant = new JobApplicant(techStack, yearsOfExperience,currentPackage);
            Message.getExpectedSalaryMessage(jobApplicant.getTechStack(), jobApplicant.getCurrentPackage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            scannerObj.close();
        }
    }

}
