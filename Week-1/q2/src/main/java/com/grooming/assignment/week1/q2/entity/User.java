package com.grooming.assignment.week1.q2.entity;

import com.grooming.assignment.week1.q2.exceptions.InvalidAadharException;
import com.grooming.assignment.week1.q2.messages.Message;
import com.grooming.assignment.week1.q2.utility.ValidationUtility;

import lombok.Getter;

@Getter
public class User {
   private String name;
   private String dateOfBirth;
   private String aadhar;    

    public User(String name, String dateOfBirth, String aadhar){
       setName(name);
       setDateOfBirth(dateOfBirth);
       setAadhar(aadhar);
    }

    public void setName(String name) {
        this.name = ValidationUtility.validateName(name.trim());
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = ValidationUtility.validateDateOfBirth(dateOfBirth);
    }

    public void setAadhar(String aadhar) {
        if(aadhar.length()!=12)
         throw new InvalidAadharException(Message.AADHAR_INVALID_EXCEPTION_MESSAGE);
         
        this.aadhar = ValidationUtility.validateAadhar(aadhar);
    }
}
