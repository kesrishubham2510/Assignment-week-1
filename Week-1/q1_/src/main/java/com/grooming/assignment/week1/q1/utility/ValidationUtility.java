package com.grooming.assignment.week1.q1.utility;

import com.grooming.assignment.week1.q1.enums.TECH_STACK;
import com.grooming.assignment.week1.q1.exceptions.ExperienceNotEnoughException;
import com.grooming.assignment.week1.q1.exceptions.RoleNotValidException;
import com.grooming.assignment.week1.q1.messages.Message;

public class ValidationUtility{

    public static TECH_STACK validateTechStack(String roleAppliedFor){
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
}