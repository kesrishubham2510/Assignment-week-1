package com.grooming.assignment.week4.q2.filters;

import java.util.concurrent.RecursiveTask;

public class NumberFilterTask extends RecursiveTask<Integer>{

    private int countOfNumbers;
    private int start;
    private int end;
    private final int THRESHOLD;
    private final int TARGET_DIGIT;
    
    public NumberFilterTask(int start, int end, int targetDigit){
        countOfNumbers = 0;
        this.start = start;
        this.end = end;
        this.THRESHOLD = 100;
        TARGET_DIGIT = targetDigit;
    }
    
    @Override
    protected Integer compute() {
        
        if((end-start+1)<=THRESHOLD)
          return countNumbers();
        else{

            NumberFilterTask subTask1 = new NumberFilterTask(start, start+THRESHOLD-1, this.TARGET_DIGIT);
            NumberFilterTask subTask2 = new NumberFilterTask(start+THRESHOLD, end, this.TARGET_DIGIT);

            subTask1.fork();
            subTask2.fork();

            return subTask1.join()+subTask2.join();
        }
    }
   
    public int getCountOfNumbers() {
        return countOfNumbers;
    }
    
    private int countNumbers(){
        
        int i,num,cnt;

        cnt = 0;

        for(i=this.start; i<=this.end;i++){
            num=i;

            while(num>=TARGET_DIGIT){
                if((num%10)==TARGET_DIGIT){
                    cnt++;
                    break;
                }else{
                    num=num/10;
                }
            }
        }
       return cnt;
    }
    
}