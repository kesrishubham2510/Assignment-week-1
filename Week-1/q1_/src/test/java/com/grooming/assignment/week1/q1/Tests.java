package com.grooming.assignment.week1.q1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.grooming.assignment.week1.q1.drivers.TestInput;
import com.grooming.assignment.week1.q1.enums.TECH_STACK;
import com.grooming.assignment.week1.q1.messages.Message;

@SpringBootTest
public class Tests {
 
     private TestInput testInput;
     String techStack, currentPackage;
     float yearsOfExperience;
     

     Tests(){
       testInput = new TestInput();   
     }
    
     @Test
     void testIdealCase(){
        
      
        techStack = "SAP";
        yearsOfExperience = 8f;
        currentPackage = "1000000";
        
        var expectedMessage = Message.getExpectedSalaryMessage(TECH_STACK.valueOf(techStack), Integer.parseInt(currentPackage));

        var actualMessage = testInput.testInput( techStack, yearsOfExperience, currentPackage);
        
        assertEquals(expectedMessage, actualMessage);
     }

     @Test
     void testCase_ExperienceNotEnoughMessage_JAVA(){
        
      
        techStack = "JAVA";
        yearsOfExperience = 2f;
        currentPackage = "1000000";
        
        var expectedMessage = Message.getExperienceExceptionMessage(TECH_STACK.valueOf(techStack));

        var actualMessage = testInput.testInput( techStack, yearsOfExperience, currentPackage);
        
        assertEquals(expectedMessage, actualMessage);
     }

     
     @Test
     void testCase_ExperienceNotEnoughMessage_QA(){
        
      
        techStack = "QA";
        yearsOfExperience = 2f;
        currentPackage = "1000000";
        
        var expectedMessage = Message.getExperienceExceptionMessage(TECH_STACK.valueOf(techStack));

        var actualMessage = testInput.testInput( techStack, yearsOfExperience, currentPackage);
        
        assertEquals(expectedMessage, actualMessage);
     }

     @Test
     void testCase_ExperienceNotEnoughMessage_SAP(){
        
      
        techStack = "SAP";
        yearsOfExperience = 2f;
        currentPackage = "1000000";
        
        var expectedMessage = Message.getExperienceExceptionMessage(TECH_STACK.valueOf(techStack));

        var actualMessage = testInput.testInput( techStack, yearsOfExperience, currentPackage);
        
        assertEquals(expectedMessage, actualMessage);
     }


     @Test
     void testCase_Invalid_TechStack(){
       
        techStack = "Javaa";
        yearsOfExperience = 9f;
        currentPackage = "1000000";
        
        var expectedMessage = Message.getTechStackNotValidExceptionMessage(TECH_STACK.values());

        var actualMessage = testInput.testInput( techStack, yearsOfExperience, currentPackage);
       
        assertEquals(expectedMessage, actualMessage);
      }      

     @Test
     void testCase_Invalid_Package(){
        
      
        techStack = "Java";
        yearsOfExperience = 9f;
        currentPackage = "100f000";
        
        var expectedMessage = Message.PACKAGE_NOT_VALID_EXCEPTION;

        var actualMessage = testInput.testInput( techStack, yearsOfExperience, currentPackage);
       
        assertEquals(expectedMessage, actualMessage);
      }
     
      



}
