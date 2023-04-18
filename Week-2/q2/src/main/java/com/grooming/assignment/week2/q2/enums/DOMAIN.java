package com.grooming.assignment.week2.q2.enums;

public enum DOMAIN {
    
    DEVELOPMENT("Development"),
    ANALYSIS("Analysis"),
    ACCOUNTS("Accounts");

    private String displayName;

    DOMAIN(String displayName){
       this.displayName = displayName;
    }

    public String getDisplayName(){
       return this.displayName;
    }

}

