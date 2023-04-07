package com.grooming.assignment.week1.q1.enums;

public enum TECH_STACK {
    
    JAVA(8,"Manager",1.45),
    SAP(4,"Sr.Associate", 1.30),
    QA(3,"Associate",1.20);

    private int minExperience;
    private String offeredRole;
    private double expectedSalaryFactor;

    TECH_STACK(int minExperience, String offeredRole, double expectedSalaryFactor){
         this.minExperience = minExperience;
         this.offeredRole = offeredRole;
         this.expectedSalaryFactor = expectedSalaryFactor;
    }

    public int getMinExperience(){
        return this.minExperience;
    } 

    public String getOfferedRole(){
        return this.offeredRole;
    }

    public double getExpectedSalaryFactor(){
        return this.expectedSalaryFactor;
    }
}
