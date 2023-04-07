package com.grooming.assignment.week1.q1;

import com.grooming.assignment.week1.q1.entity.JobApplicant;

public class DataUtility {
    
     public static JobApplicant generateJobApplicant(String firstName, String lastName, String techStack, float yearsOfExperience, String currentPackage){
         return new JobApplicant(firstName, lastName, techStack, yearsOfExperience, currentPackage);
     }
}
