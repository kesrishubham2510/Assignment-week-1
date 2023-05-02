package com.grooming.assignment.week4.q1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.grooming.assignment.week4.q1.drivers.InputTester;
import com.grooming.assignment.week4.q1.entities.Product;
import com.grooming.assignment.week4.q1.enums.Category;

@SpringBootTest
public class ItemTest {

    private int MAX_ITEMS = 10;
    private InputTester inputTester;
    private ProductData productData;
    private List<Product> products;

    public ItemTest() {
        inputTester = new InputTester();
        productData = new ProductData(MAX_ITEMS);
        products = productData.getProducts();
    }

    @Test
    void testWarrantyProducts_Laptop() {

        List<Product> expectedWarrantyProducts = List.of(
                new Product("8", "product@8", true, "LAPTOP"));

        List<Product> expectedNonWarrantyProducts = List.of(
                new Product("4", "product@4", false, "LAPTOP"));

        List<List<Product>> actualProducts = inputTester.testInput(products, Category.LAPTOP);

        assertEquals(expectedWarrantyProducts.get(0).getId(), actualProducts.get(0).get(0).getId());

        assertEquals(expectedNonWarrantyProducts.get(0).getId(), actualProducts.get(1).get(0).getId());
    }

    @Test
    void testWarrantyProducts_TV() {

        List<Product> expectedWarrantyProducts = List.of(
                new Product("7", "product@7", true, "TV"));

        List<Product> expectedNonWarrantyProducts = List.of(
                new Product("3", "product@3", false, "TV"));

        List<List<Product>> actualProducts = inputTester.testInput(products, Category.TV);

        assertEquals(expectedWarrantyProducts.get(0).getId(), actualProducts.get(0).get(0).getId());

        assertEquals(expectedNonWarrantyProducts.get(0).getId(), actualProducts.get(1).get(0).getId());

    }

    @Test
    void testWarrantyProducts_REFRIGERATOR() {

        List<Product> expectedWarrantyProducts = List.of(
                new Product("10", "product@10", true, "REFRIGERATOR"));

        List<Product> expectedNonWarrantyProducts = List.of(
                new Product("6", "product@6", false, "REFRIGERATOR"));

        List<List<Product>> actualProducts = inputTester.testInput(products, Category.REFRIGERATOR);
        assertEquals(expectedWarrantyProducts.get(0).getId(), actualProducts.get(0).get(0).getId());
        assertEquals(expectedNonWarrantyProducts.get(0).getId(), actualProducts.get(1).get(0).getId());

    }

    @Test
    void testWarrantyProducts_MOBILE() {

        List<Product> expectedWarrantyProducts = List.of(
                new Product("9", "product@9", true, "MOBILE")

        );

        List<Product> expectedNonWarrantyProducts = List.of(
                new Product("5", "product@5", false, "MOBILE"));

        List<List<Product>> actualProducts = inputTester.testInput(products, Category.MOBILE);
        assertEquals(expectedWarrantyProducts.get(0).getId(), actualProducts.get(0).get(0).getId());

        assertEquals(expectedNonWarrantyProducts.get(0).getId(), actualProducts.get(1).get(0).getId());

    }

}