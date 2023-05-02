package com.grooming.assignment.week4.q1.drivers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.grooming.assignment.week4.q1.entities.Product;
import com.grooming.assignment.week4.q1.enums.Category;
import com.grooming.assignment.week4.q1.utilities.FilterUtility;

public class InputTester {
    
    public List<List<Product>> testInput(List<Product> products, Category category){
       
        List<List<Product>> ans = new ArrayList<>();

         try {
            // true flag is used to filter the products having warranty
            Map<Boolean, List<Product>> itemsWithWarranty =  products.stream().filter((product)->FilterUtility.categoryFilter.test(product, category)).collect(Collectors.partitioningBy(FilterUtility.warrantyBasedFilter));
          
            ans.add(itemsWithWarranty.get(true));
            ans.add(itemsWithWarranty.get(false));

         } catch (Exception e) {
            System.out.println(e.getMessage());
         }

         return ans;
    }

    public void printProductList(List<Product> products){
        
        products.stream().forEach(FilterUtility.productConsumer);
    }

}
