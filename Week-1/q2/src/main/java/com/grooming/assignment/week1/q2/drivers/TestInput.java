package com.grooming.assignment.week1.q2.drivers;

import com.grooming.assignment.week1.q2.entity.User;
import com.grooming.assignment.week1.q2.messages.Message;

public class TestInput {
    
    public String testInput(String firstName, String dateOfBirth, String aadhar){

        String message = "";

        try {         
            User user = new User(firstName, dateOfBirth,aadhar);
            message = Message.generateUSerName(user);
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        return message;
    }
}
