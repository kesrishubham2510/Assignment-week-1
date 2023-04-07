package com.grooming.assignment.week1.q1.entity;

import com.grooming.assignment.week1.q1.enums.TECH_STACK;
import com.grooming.assignment.week1.q1.exceptions.PackageNotValidException;
import com.grooming.assignment.week1.q1.messages.Message;
import com.grooming.assignment.week1.q1.utility.ValidationUtility;

public class JobApplicant {
    private String name;
    private TECH_STACK techStackApplyingFor;
    private float yearsOfExperience;
    private int currentPackage;

    public JobApplicant(String firstName, String lastName, String techStackApplyingFor, float yearsOfExperience, String currentPackage){
        setName(firstName, lastName);
        setTechStackApplyingFor(techStackApplyingFor);
        setYearsOfExperience(yearsOfExperience);
        setCurrentPackage(currentPackage);
    }

    public TECH_STACK getTechStack(){
      return this.techStackApplyingFor;
    }

    public int getCurrentPackage(){
      return this.currentPackage;
    }

    private void setName(String firstName, String lastName){
       this.name = ValidationUtility.validateJobApplicantName(firstName, lastName);
    }

    private void setTechStackApplyingFor(String techStackApplyingFor){
       this.techStackApplyingFor = ValidationUtility.validateJobRole(techStackApplyingFor); 
    }

    private void setYearsOfExperience(float yearsOfExperience){
       this.yearsOfExperience = ValidationUtility.validateYearsOfExperience(this.techStackApplyingFor,yearsOfExperience); 
    }

    private void setCurrentPackage(String currentPackage){
       try {
         this.currentPackage = Integer.parseInt(currentPackage);
       } catch (Exception e) {
          throw new PackageNotValidException(Message.PACKAGE_NOT_VALID_EXCEPTION);
       }
    }
}
