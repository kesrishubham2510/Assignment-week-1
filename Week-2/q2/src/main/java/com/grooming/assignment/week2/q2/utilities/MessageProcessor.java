package com.grooming.assignment.week2.q2.utilities;

import com.grooming.assignment.week2.q2.config.Constant;
import com.grooming.assignment.week2.q2.enums.DOMAIN;
import com.grooming.assignment.week2.q2.enums.EMPLOYMENT_TYPE;
import com.grooming.assignment.week2.q2.enums.ROLE;

public class MessageProcessor{
    
    public String getEmploymentTypeErrorMessage(){

        StringBuilder strBuilder = new StringBuilder();
        int noOfConstants = EMPLOYMENT_TYPE.values().length;

        for(int i=0; i< noOfConstants-1;i++)
          strBuilder.append(EMPLOYMENT_TYPE.values()[i].getDisplayName()+", ");
        
          strBuilder.append(EMPLOYMENT_TYPE.values()[noOfConstants-1].getDisplayName()+" ]");
        
        return String.format(Constant.ENUM_EXCEPTION_MESSAGE, EMPLOYMENT_TYPE.class.getSimpleName(),strBuilder.toString());
    }

    public String getDomainErrorMessage(){

        StringBuilder strBuilder = new StringBuilder();
        int noOfConstants = DOMAIN.values().length;

        for(int i=0; i< noOfConstants-1;i++)
          strBuilder.append(DOMAIN.values()[i].getDisplayName()+", ");
        
          strBuilder.append(DOMAIN.values()[noOfConstants-1].getDisplayName()+" ]");
        
        return String.format(Constant.ENUM_EXCEPTION_MESSAGE, DOMAIN.class.getSimpleName(),strBuilder.toString());
    }

    public String getRoleErrorMessage(){

        StringBuilder strBuilder = new StringBuilder();
        int noOfConstants = ROLE.values().length;

        for(int i=0; i< noOfConstants-1;i++)
          strBuilder.append(ROLE.values()[i].getDisplayName()+", ");
        
          strBuilder.append(ROLE.values()[noOfConstants-1].getDisplayName()+" ]");
        
        return String.format(Constant.ENUM_EXCEPTION_MESSAGE, ROLE.class.getSimpleName(),strBuilder.toString());
    }

    // public String getEnumerationTypeErrorMessage(Class<? extends EMPLOYMENT_TYPE & ROLE & STATUS> enumerationClass){

    //     StringBuilder strBuilder = new StringBuilder();
    //     int noOfConstants = enumerationClass.getFields().length;

    //     for(int i=0; i< noOfConstants-1;i++)
    //       strBuilder.append(enumerationClass.getFields()[i].getName()+", ");
        
    //     //   strBuilder.append(enumerationClass.values()[noOfConstants-1].getDisplayName()+" ]");
        
    //     return null;
    //     //  String.format(Constant.enumErrorMessage, enumerationClass.class.getSimpleName(),strBuilder.toString());
    // }

    // public void getEmploymentTypeErrorMessage(Class<EMPLOYMENT_TYPE> class1) {
    // }

}
