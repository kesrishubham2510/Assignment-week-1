package com.grooming.assignment.week2.q2.enums;

public enum EMPLOYMENT_TYPE{
    CONTRACT ("Contract"),
    FULL_TIME("Full time");

    private String displayname;

    
    EMPLOYMENT_TYPE(String displayName){
        this.displayname = displayName;
    }
    
    public String getDisplayName() {
        return displayname;
    }

}
