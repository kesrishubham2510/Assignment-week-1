package com.grooming.assignment.week4.q3.utilities;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Counter{

   
    public static int calculateSumInIntervalsOfTen() throws InterruptedException, ExecutionException{


        CompletableFuture<Integer> sum_1_to_30 = CompletableFuture.supplyAsync(()->{
            int sum=0;
            for(int i=1;i<=10;i++)
             sum+=i;
            
             return sum;
        }).thenApply((previousSum)->{
    
            for(int i=11;i<=20;i++)
             previousSum+=i;
            
             return previousSum;
        }).thenApply((previousSum)->{
    
            for(int i=21;i<=30;i++)
             previousSum+=i;
            
             return previousSum;
        });

        return sum_1_to_30.get();
    }   
}