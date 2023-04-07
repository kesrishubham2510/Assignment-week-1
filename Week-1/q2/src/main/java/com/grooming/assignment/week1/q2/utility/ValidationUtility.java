package com.grooming.assignment.week1.q2.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import com.grooming.assignment.week1.q2.exceptions.InvalidAadharException;
import com.grooming.assignment.week1.q2.exceptions.InvalidDateOfBirthException;
import com.grooming.assignment.week1.q2.exceptions.NameNotValidException;
import com.grooming.assignment.week1.q2.messages.Message;

public class ValidationUtility {

    public static String validateName(String name) {

        StringBuilder strBuilder = new StringBuilder();

        Predicate<String>  filterEmptyStrings = str-> str.trim().length()!=0 ;

        if (ValidationUtility.isAlphanumeric(name))
            throw new NameNotValidException(Message.NAME_NOT_VALID_MESSAGE);
       
        var names = Arrays.stream(name.split(" ")).filter(filterEmptyStrings).collect(Collectors.toList());    
            
         if(names.size()==2){
             strBuilder.append(names.get(0).trim());
             strBuilder.append(" ");
             strBuilder.append(names.get(1).trim());
         }
         else
          throw new NameNotValidException(Message.ONLY_ENTER_FIRST_LAST_NAME);

        if(strBuilder.toString().length()<4)
         throw new NameNotValidException(Message.NAME_TOO_SHORT);
     
        return strBuilder.toString();
    }

    public static String validateDateOfBirth(String dateOfBirthString) {

        LocalDate dateOfBirth;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {

            dateOfBirth = LocalDate.parse(dateOfBirthString, formatter);

            if(!dateOfBirth.isBefore(LocalDate.now().minusYears(18)))
             throw new InvalidDateOfBirthException(Message.DOB_INVALID_MESSAGE);

        } catch (IllegalArgumentException exception) {
            throw new InvalidDateOfBirthException(Message.DOB_INVALID_MESSAGE);
        }

        return formatter.format(dateOfBirth);
    }

    public static String validateAadhar(String aadhar) {

        try {
            Long.parseLong(aadhar);
        } catch (Exception e) {
            throw new InvalidAadharException(Message.AADHAR_INVALID_EXCEPTION_MESSAGE);
        }
        return aadhar;
    }

    private static boolean isAlphanumeric(String str) {

        if (str.trim().length() == 0)
            return true;

        int i = 0, len;
        len = str.length();
        String lowerCaseString = str.toLowerCase();

        for (i = 0; i < len; i++) {
            if(lowerCaseString.charAt(i)==' ')
             continue;

            if (!(lowerCaseString.charAt(i) >= 'a' && lowerCaseString.charAt(i) <= 'z'))
                return true;
        }

        return false;
    }

}
