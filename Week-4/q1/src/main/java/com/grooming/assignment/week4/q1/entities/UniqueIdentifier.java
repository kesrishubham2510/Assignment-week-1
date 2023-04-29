package com.grooming.assignment.week4.q1.entities;

public class UniqueIdentifier{

    private static String id="-1";

    public static String getId(){
        id = String.valueOf((Integer.parseInt(id)+1));
        return "Product@"+id;
    }

}