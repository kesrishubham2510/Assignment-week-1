package com.grooming.assignment.week1.q2.messages;

import com.grooming.assignment.week1.q2.entity.User;

public class Message {
    public static final String NAME_NOT_VALID_MESSAGE = "Name should not contain any digits or special characters or empty or whitespaces.";
    public static final String NAME_TOO_SHORT = "Name must be atleast 4 four characters long.";
    public static final String ONLY_ENTER_FIRST_LAST_NAME = "Please provide your first and last name only";
    public static final String AADHAR_INVALID_EXCEPTION_MESSAGE = "The Aadhar number should not only contain digits [0-9], please check and try again."; 
    public static final String DOB_INVALID_MESSAGE = "Age must be atleast 18 years & in the format dd-MM-yyyy"; 
    public static String USERNAME_MESSAGE = "Thank you for using our service, your user name is %s";

    public static String generateUSerName(User user){
       StringBuilder strBuilder = new StringBuilder();
       strBuilder.append(user.getName().substring(0, 4));
       strBuilder.append(user.getDateOfBirth().toString().substring(0, 2));
       strBuilder.append(user.getDateOfBirth().substring(6));
       strBuilder.append(user.getAadhar().substring(8));

       return String.format(USERNAME_MESSAGE, strBuilder.toString());
    }
}
