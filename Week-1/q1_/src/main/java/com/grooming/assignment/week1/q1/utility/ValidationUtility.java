package com.grooming.assignment.week1.q1.utility;

import com.grooming.assignment.week1.q1.enums.TECH_STACK;
import com.grooming.assignment.week1.q1.exceptions.ExperienceNotEnoughException;
import com.grooming.assignment.week1.q1.exceptions.NameNotValidException;
import com.grooming.assignment.week1.q1.exceptions.RoleNotValidException;
import com.grooming.assignment.week1.q1.messages.Message;

public class ValidationUtility{
   
    public static String validateJobApplicantName(String firstName, String lastName){
        
        StringBuilder strBuilder = new StringBuilder();

        if(ValidationUtility.isAlphanumeric(firstName))
         throw new NameNotValidException(Message.NAME_NOT_VALID_MESSAGE);
        
         strBuilder.append(firstName.trim());
         
         if(lastName.trim().length()!=0 && ValidationUtility.isAlphanumeric(lastName)){
             throw new NameNotValidException(Message.NAME_NOT_VALID_MESSAGE);      
         }else{
            strBuilder.append(" "+lastName);
         }
          
        return strBuilder.toString().trim();
    }

    public static TECH_STACK validateJobRole(String roleAppliedFor){
        String upperCaseJobRole = roleAppliedFor.toUpperCase();
        TECH_STACK role;

        try {
            role = TECH_STACK.valueOf(upperCaseJobRole);    
        } catch (IllegalArgumentException exception) {
            throw new RoleNotValidException(Message.getTechStackNotValidExceptionMessage(TECH_STACK.values()));
        }

        
        return role;
    }

    public static int validateYearsOfExperience(TECH_STACK roleApplyingFor,float yearsOfExperience){

        if(roleApplyingFor.getMinExperience()>yearsOfExperience)
         throw new ExperienceNotEnoughException(Message.getExperienceExceptionMessage(roleApplyingFor));

        return 0;
    }

    private static boolean isAlphanumeric(String str){

        if(str.trim().length()==0)
         return true;

        int i=0,len;
        len = str.length();
        String lowerCaseString = str.toLowerCase();

        for(i=0;i<len;i++){
            if(!(lowerCaseString.charAt(i)>='a' && lowerCaseString.charAt(i)<='z'))
             return true;
        }

        return false;
    }

}