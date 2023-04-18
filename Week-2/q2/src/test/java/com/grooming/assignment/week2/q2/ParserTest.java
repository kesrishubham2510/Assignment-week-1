package com.grooming.assignment.week2.q2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.grooming.assignment.week2.q2.drivers.InputTestDriver;

@SpringBootTest
public class ParserTest {
    
    private InputTestDriver inputTestDriver;
   
    ParserTest() {
        inputTestDriver = new InputTestDriver();
    }

    @Test
    void intiateParsingProcess() throws Exception{
        inputTestDriver.processInput("input.txt");
    }

    /*
     
        display,2
        all employees,ASSOCIATE
        all employees,2 
     */
}
