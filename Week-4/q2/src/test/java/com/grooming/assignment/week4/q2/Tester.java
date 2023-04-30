package com.grooming.assignment.week4.q2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ForkJoinPool;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.grooming.assignment.week4.q2.filters.NumberFilterTask;

@SpringBootTest
public class Tester {
    
    @Test
    void testCount(){
        int expectedCount = 271;
        ForkJoinPool forkJoinPool = new ForkJoinPool();
		NumberFilterTask task1 = new NumberFilterTask(1,1000,9);
		assertEquals(expectedCount,forkJoinPool.invoke(task1));
    }
}
