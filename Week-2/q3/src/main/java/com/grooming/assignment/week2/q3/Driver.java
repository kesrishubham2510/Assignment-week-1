package com.grooming.assignment.week2.q3;

public class Driver {
    public static void main(String[] args) {
        
        Integer[] integerList = new Integer[6];
        integerList[0] = 1;
        integerList[1] = 3;
        integerList[2] = 5;
        integerList[3] = 2;
        integerList[4] = 9;
        integerList[5] = 7;

        CustomSorter<Integer> customSorter = new CustomSorter<>();
        customSorter.sort(integerList);
        
        String[] striingList = new String[6];
        striingList[0] = "a";
        striingList[1] = "d";
        striingList[2] = "b";
        striingList[3] = "e";
        striingList[4] = "g";
        striingList[5] = "f";

        CustomSorter<String> customSorterString = new CustomSorter<>();
        customSorterString.sort(striingList);
    }
}
