package com.grooming.assignment.week2.q1.enums;

public enum STATUS {
    
    ACTIVE("Active"),
    EXIT("Left"),
    SERVING_NOTICE("On Notice Period");

    private String displayName;

    STATUS(String displayName){
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    
    }
}

