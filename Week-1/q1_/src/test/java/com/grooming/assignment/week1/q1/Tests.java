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
     String firstName, lastName, techStack, currentPackage;
     float yearsOfExperience;
     

     Tests(){
       testInput = new TestInput();   
     }
    
     @Test
     void testIdealCase(){
        
        firstName = "Shubham";
        lastName = "Kesri";
        techStack = "SAP";
        yearsOfExperience = 8f;
        currentPackage = "1000000";
        
        var expectedMessage = Message.getExpectedSalaryMessage(TECH_STACK.valueOf(techStack), Integer.parseInt(currentPackage));

        var actualMessage = testInput.displayMessage(firstName, lastName, techStack, yearsOfExperience, currentPackage);
        
        assertEquals(expectedMessage, actualMessage);
     }

     @Test
     void testCase_ExperienceNotEnoughMessage_JAVA(){
        
        firstName = "Shubham";
        lastName = "Kesri";
        techStack = "JAVA";
        yearsOfExperience = 2f;
        currentPackage = "1000000";
        
        var expectedMessage = Message.getExperienceExceptionMessage(TECH_STACK.valueOf(techStack));

        var actualMessage = testInput.displayMessage(firstName, lastName, techStack, yearsOfExperience, currentPackage);
        
        assertEquals(expectedMessage, actualMessage);
     }

     
     @Test
     void testCase_ExperienceNotEnoughMessage_QA(){
        
        firstName = "Shubham";
        lastName = "Kesri";
        techStack = "QA";
        yearsOfExperience = 2f;
        currentPackage = "1000000";
        
        var expectedMessage = Message.getExperienceExceptionMessage(TECH_STACK.valueOf(techStack));

        var actualMessage = testInput.displayMessage(firstName, lastName, techStack, yearsOfExperience, currentPackage);
        
        assertEquals(expectedMessage, actualMessage);
     }

     @Test
     void testCase_ExperienceNotEnoughMessage_SAP(){
        
        firstName = "Shubham";
        lastName = "Kesri";
        techStack = "SAP";
        yearsOfExperience = 2f;
        currentPackage = "1000000";
        
        var expectedMessage = Message.getExperienceExceptionMessage(TECH_STACK.valueOf(techStack));

        var actualMessage = testInput.displayMessage(firstName, lastName, techStack, yearsOfExperience, currentPackage);
        
        assertEquals(expectedMessage, actualMessage);
     }

     @Test
     void testCase_NameNotValidMessage(){
        
        firstName = "Shubha45";
        lastName = "Kesri";
        techStack = "JAVA";
        yearsOfExperience = 2f;
        currentPackage = "1000000";
        
        var expectedMessage = Message.NAME_NOT_VALID_MESSAGE;

        var actualMessage = testInput.displayMessage(firstName, lastName, techStack, yearsOfExperience, currentPackage);
        
        assertEquals(expectedMessage, actualMessage);
     }

     @Test
     void testCase_ValidNameWithout_LastName(){
        
        firstName = "Shubham";
        lastName = "  ";
        techStack = "JAVA";
        yearsOfExperience = 9f;
        currentPackage = "1000000";
        
        var expectedMessage = Message.getExpectedSalaryMessage(TECH_STACK.valueOf(techStack), Integer.parseInt(currentPackage));

        var actualMessage = testInput.displayMessage(firstName, lastName, techStack, yearsOfExperience, currentPackage);
       
        assertEquals(expectedMessage, actualMessage);
      }

     @Test
     void testCase_Invalid_TechStack(){
        
        firstName = "Shubham";
        lastName = "  ";
        techStack = "Javaa";
        yearsOfExperience = 9f;
        currentPackage = "1000000";
        
        var expectedMessage = Message.getTechStackNotValidExceptionMessage(TECH_STACK.values());

        var actualMessage = testInput.displayMessage(firstName, lastName, techStack, yearsOfExperience, currentPackage);
       
        assertEquals(expectedMessage, actualMessage);
      }      

     @Test
     void testCase_Invalid_Package(){
        
        firstName = "Shubham";
        lastName = "Kesri";
        techStack = "Java";
        yearsOfExperience = 9f;
        currentPackage = "100f000";
        
        var expectedMessage = Message.PACKAGE_NOT_VALID_EXCEPTION;

        var actualMessage = testInput.displayMessage(firstName, lastName, techStack, yearsOfExperience, currentPackage);
       
        assertEquals(expectedMessage, actualMessage);
      }
     
      



}
