package com.grooming.assignment.week4.q1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.grooming.assignment.week4.q1.drivers.InputTester;
import com.grooming.assignment.week4.q1.entities.Product;

@SpringBootTest
public class ItemTest{

    private int MAX_ITEMS = 10;
    private InputTester inputTester;
    private ProductData productData;
    private List<Product> products;

    public ItemTest(){
        inputTester = new InputTester();
        productData = new ProductData(MAX_ITEMS);
        products = productData.getProducts();
    }

    @Test
    void testWarrantyProducts(){

        List<Product> expectedWarrantyProducts = List.of(
            new Product("Product@0","product@Product@0", true, "REFRIGERATOR"),
            new Product("Product@1","product@Product@1", true, "MOBILE"),
            new Product("Product@2","product@Product@2", true, "LAPTOP"),
            new Product("Product@3","product@Product@3", true, "TV"),
            new Product("Product@8","product@Product@8", true, "REFRIGERATOR"),
            new Product("Product@9","product@Product@9", true, "MOBILE")
        );

        List<Product> expectedNonWarrantyProducts = List.of(
            new Product("Product@4","product@Product@4", false, "REFRIGERATOR"),
            new Product("Product@5","product@Product@5", false, "MOBILE"),
            new Product("Product@6","product@Product@6", false, "LAPTOP"),
            new Product("Product@7","product@Product@7", false, "TV")
        );

        List<List<Product>> actualProducts = inputTester.testInput(products);

        assertEquals(expectedWarrantyProducts.get(0).getId(), actualProducts.get(0).get(0).getId());
        assertEquals(expectedWarrantyProducts.get(1).getId(), actualProducts.get(0).get(1).getId());
        assertEquals(expectedWarrantyProducts.get(2).getId(), actualProducts.get(0).get(2).getId());
        assertEquals(expectedWarrantyProducts.get(3).getId(), actualProducts.get(0).get(3).getId());
        assertEquals(expectedWarrantyProducts.get(4).getId(), actualProducts.get(0).get(4).getId());
        assertEquals(expectedWarrantyProducts.get(5).getId(), actualProducts.get(0).get(5).getId());
        
        assertEquals(expectedNonWarrantyProducts.get(0).getId(), actualProducts.get(1).get(0).getId());
        assertEquals(expectedNonWarrantyProducts.get(1).getId(), actualProducts.get(1).get(1).getId());
        assertEquals(expectedNonWarrantyProducts.get(2).getId(), actualProducts.get(1).get(2).getId());
        assertEquals(expectedNonWarrantyProducts.get(3).getId(), actualProducts.get(1).get(3).getId());

    }

    
}