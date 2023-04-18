package com.grooming.assignment.week2.q2.enums;

public enum ROLE {
    ASSOCIATE("Associate"),
    SENIOR_ASSOCIATE("Senior Associate");

    private String displayName;

    ROLE(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return this.displayName;
    }
}
