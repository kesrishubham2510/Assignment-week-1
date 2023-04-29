package com.grooming.assignment.week4.q1.utilities;

import com.grooming.assignment.week4.q1.enums.Category;
import com.grooming.assignment.week4.q1.exceptions.InvalidCategoryException;

public class ValidationUtility {
    
    public static Category validateProductCategory(String category){

        Category productCategory;

        try {
            productCategory = Category.valueOf(category.toUpperCase());
        }catch (Exception e) {
            System.out.println(e.getMessage());
            throw new InvalidCategoryException(MessageUtility.generateMessage(category));
        }

        return productCategory;
    }
}
