package com.grooming.assignment.week4.q1.enums;

public enum Category{
    REFRIGERATOR("refrigerator"),
    MOBILE("mobile"), 
    LAPTOP("laptop"), 
    TV("tv");

    private String category;

    Category(String category){
        this.category = category;
    }
    
    public String getCategory() {
        return category;
    }
    
}