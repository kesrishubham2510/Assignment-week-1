package com.grooming.assignment.week4.q1.utilities;

import com.grooming.assignment.week4.q1.enums.Category;

public class MessageUtility{

    public static String TECHSTACK_NOT_VALID_MESSAGE = "We don't have %s category. You can choose a category from %s only";

    public static String generateMessage(String currentCategory){

        StringBuilder stringBuilder = new StringBuilder("[ ");
        
        Category[] categories = Category.values();
        int noOfCategories = categories.length;

        for(int i=0; i< noOfCategories-1; i++){
            stringBuilder.append(categories[i]);
            stringBuilder.append(", ");
        }

        stringBuilder.append(categories[noOfCategories-1]);
        stringBuilder.append(" ]");

        return String.format(TECHSTACK_NOT_VALID_MESSAGE, currentCategory, stringBuilder.toString());
    }

}