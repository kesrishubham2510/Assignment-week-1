package com.grooming.assignment.week4.q1.entities;

import com.grooming.assignment.week4.q1.enums.Category;
import com.grooming.assignment.week4.q1.utilities.ValidationUtility;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Product {

    private String id;
    private String name;
    private boolean warranty;
    private Category category;
    

    public Product(String name, boolean warranty, String category) {

        setId();
        setName(name);
        setWarranty(warranty);
        setCategory(category);
    }

    public Product(String id,String name, boolean warranty, String category) {

        this.id = id;
        setName(name);
        setWarranty(warranty);
        setCategory(category);
    }

    public void setId() {
        this.id = UniqueIdentifier.getId();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }

    public void setCategory(String category) {
        this.category = ValidationUtility.validateProductCategory(category);
    }
}