package com.grooming.assignment.week2.q3;

public class CustomSorter<T>{

    public void sort(T[] array){
        
        // T can be int, char, String
        int i,j,len=array.length;
        T temp;

        for(i=0;i<len;i++){
            for(j=1;j<len;j++){
                if( ((Comparable)array[j-1]).compareTo(array[j]) == 1){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }

        for(i=0;i<len;i++){
            System.out.print(array[i]+", ");
        }

        System.out.println();
    }    
}
