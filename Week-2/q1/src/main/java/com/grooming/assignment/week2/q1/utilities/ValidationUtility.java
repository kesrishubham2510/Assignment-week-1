package com.grooming.assignment.week2.q1.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.grooming.assignment.week2.q1.config.Constant;
import com.grooming.assignment.week2.q1.enums.EMPLOYMENT_TYPE;
import com.grooming.assignment.week2.q1.enums.ROLE;
import com.grooming.assignment.week2.q1.enums.STATUS;
import com.grooming.assignment.week2.q1.exceptions.InvalidDateFormatException;
import com.grooming.assignment.week2.q1.exceptions.InvalidEmployementTypeException;

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

          try {
            employment = EMPLOYMENT_TYPE.valueOf(EMPLOYMENT_TYPE.class, employmentType);
          }catch (Exception ex) {
             var messageProcessor = new MessageProcessor();
             throw new InvalidEmployementTypeException(messageProcessor.getEmploymentTypeErrorMessage());
          }
          return employment;
    }

    public static ROLE validateRoleType(String roleType){
          ROLE role=null;

          try {
            role = EMPLOYMENT_TYPE.valueOf(ROLE.class, roleType);
          }catch (Exception ex) {
             var messageProcessor = new MessageProcessor();
             throw new InvalidEmployementTypeException(messageProcessor.getRoleErrorMessage());
          }
          return role;
    }

    public static STATUS validateStatusType(String statusType){
          STATUS status=null;

          try {
            status = STATUS.valueOf(STATUS.class, statusType);
          }catch (Exception ex) {
             var messageProcessor = new MessageProcessor();
             throw new InvalidEmployementTypeException(messageProcessor.getStatusErrorMessage());
          }
          return status;
    }
}
