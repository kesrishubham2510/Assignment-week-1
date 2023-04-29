package com.grooming.assignment.week4.q1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.grooming.assignment.week4.q1.entities.Product;
import com.grooming.assignment.week4.q1.enums.Category;

public class ProductData {
    
    private static int counter;
    private static int oddSwitch;
    private List<Product> products;
    private Category[] categories;

    private Supplier<Product> productGenerator = ()-> {
        Product product = new Product("", false, "tv");
       
        product.setName("product@"+product.getId());
        product.setCategory(categories[counter%(categories.length)].toString());
        product.setWarranty(oddSwitch==0 ? true: false);
       
        counter = (counter+1)%(categories.length); 

        if(counter==0)
         oddSwitch = (oddSwitch+1)%2;

        return product;
    };

    public ProductData(int noOfItems){
        counter=0;
        oddSwitch=0;
        products = new ArrayList<>();
        categories = Category.values();
        populateProducts(noOfItems);
    }

    public List<Product> getProducts(){
        return this.products;
    }

    private void populateProducts(int noOfItems){
        for(int i=0;i<noOfItems;i++)
         products.add(productGenerator.get());
    }

    

}
