package com.grooming.assignment.week2.q3;

public class GeneralSorter<T extends Comparable<T>>{

    public void sort(T[] array){
        
        // T can be int, char, String
        int i,j,len=array.length;
        T temp;

        for(i=0;i<len-1;i++){
            for(j=i+1;j<len;j++){
                if((array[i]).compareTo(array[j]) > 0){
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

        for(i=0;i<len;i++){
            System.out.print(array[i]+", ");
        }

        System.out.println();
    }    
}
