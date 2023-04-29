package com.grooming.assignment.week4.q1.utilities;

import java.util.function.BiPredicate;
import java.util.function.Consumer;

import com.grooming.assignment.week4.q1.entities.Product;

public class FilterUtility {
    
    public static BiPredicate<Product, Boolean> warrantyFilter = (product, warrantyFlag)->{
        return warrantyFlag ? product.isWarranty() : !product.isWarranty();
    };

    public static Consumer<Product> productConsumer = (product)-> System.out.println(product);;
}
