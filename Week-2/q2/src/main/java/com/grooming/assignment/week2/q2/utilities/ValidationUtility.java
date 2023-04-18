package com.grooming.assignment.week2.q2.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.grooming.assignment.week2.q2.config.Constant;
import com.grooming.assignment.week2.q2.enums.DOMAIN;
import com.grooming.assignment.week2.q2.enums.EMPLOYMENT_TYPE;
import com.grooming.assignment.week2.q2.enums.ROLE;
import com.grooming.assignment.week2.q2.exceptions.InvalidDateFormatException;
import com.grooming.assignment.week2.q2.exceptions.InvalidEnumerationTypeException;

public class ValidationUtility {
    
    public static LocalDate validateJoiningDate(String date){
        
        LocalDate joiningDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constant.DATE_FORMAT);

        try {
            joiningDate = LocalDate.parse(date, formatter);
            if(joiningDate.isAfter(LocalDate.now()))
             throw new InvalidDateFormatException(Constant.INVALID_DATE_EXCEPTION_MESSAGE);
        }catch(InvalidDateFormatException ex){
            throw ex;
        } 
        catch (Exception e){
            throw new InvalidDateFormatException(Constant.DATE_FORMAT_EXCEPTION_MESSAGE);
        }
        return joiningDate;
    }

    public static EMPLOYMENT_TYPE validateEmploymentType(String employmentType){
          EMPLOYMENT_TYPE employment=null;
          
            switch(employmentType.toUpperCase()){

               case "CONTRACT": employment = EMPLOYMENT_TYPE.CONTRACT;
                                break;
               case "FULL TIME": employment = EMPLOYMENT_TYPE.FULL_TIME;
                                  break;
               default: {
                          var messageProcessor = new MessageProcessor();
                          throw new InvalidEnumerationTypeException(messageProcessor.getEmploymentTypeErrorMessage());                    
                        }
            }
          return employment;
    }

    public static ROLE validateRoleType(String roleType){
          ROLE role=null;

          switch(roleType.toUpperCase()){

            case "ASSOCIATE": role = ROLE.ASSOCIATE;
                               break;
            case "SENIOR ASSOCIATE": role = ROLE.SENIOR_ASSOCIATE;
                               break;
            default: {
                       var messageProcessor = new MessageProcessor();
                       throw new InvalidEnumerationTypeException(messageProcessor.getRoleErrorMessage());                    
              }
         }
          return role;
    }

    public static DOMAIN validateStatusType(String statusType){
          DOMAIN domain=null;

          switch(statusType.toUpperCase()){

            case "DEVELOPMENT": domain = DOMAIN.DEVELOPMENT;
                               break;
            case "ANALYSIS": domain = DOMAIN.ANALYSIS;
                               break;                   
            case "ACCOUNTS": domain = DOMAIN.ACCOUNTS;
                               break;

            default: {
                       var messageProcessor = new MessageProcessor();
                       throw new InvalidEnumerationTypeException(messageProcessor.getDomainErrorMessage());                    
              }
         }
          return domain;
    }
}
