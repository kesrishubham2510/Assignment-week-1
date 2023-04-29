package com.grooming.assignment.week4.q1.drivers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.grooming.assignment.week4.q1.entities.Product;
import com.grooming.assignment.week4.q1.utilities.FilterUtility;

public class InputTester {
    
    public List<List<Product>> testInput(List<Product> products){
       
        List<List<Product>> ans = new ArrayList<>();

         try {
            // true flag is used to filter the products having warranty
            List<Product> itemsWithWarranty =  products.stream().filter(product-> FilterUtility.warrantyFilter.test(product, true)).collect(Collectors.toList());
            // false flag is used to filter the products having warranty
            List<Product> itemWithoutWarranty = products.stream().filter(product-> FilterUtility.warrantyFilter.test(product, false)).collect(Collectors.toList());

            ans.add(itemsWithWarranty);
            ans.add(itemWithoutWarranty);

         } catch (Exception e) {
            System.out.println(e.getMessage());
         }

         return ans;
    }

    public void printProductList(List<Product> products){
        
        products.stream().forEach(FilterUtility.productConsumer);
    }

}
