package com.grooming.assignment.week4.q1.utilities;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.grooming.assignment.week4.q1.entities.Product;
import com.grooming.assignment.week4.q1.enums.Category;

public class FilterUtility {
    
    public static Predicate<Product> warrantyBasedFilter = (product)-> product.isWarranty(); 

    public static BiPredicate<Product, Boolean> warrantyFilter = (product, warrantyFlag)->{
        return warrantyFlag ? product.isWarranty() : !product.isWarranty();
    };

    public static Consumer<Product> productConsumer = (product)-> System.out.println(product);
    public static BiPredicate<Product, Category> categoryFilter = (product, targetCategory)-> product.getCategory().equals(targetCategory);
}
