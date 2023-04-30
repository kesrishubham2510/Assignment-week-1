package com.grooming.assignment.week4.q3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.grooming.assignment.week4.q3.utilities.Counter;

@SpringBootTest
public class CounterTest {

    @Test
    void testCounter() throws InterruptedException, ExecutionException {

        int expectedResult = 465;
        int actualResult = Counter.calculateSumInIntervalsOfTen();

        assertEquals(expectedResult, actualResult);
    }
}
