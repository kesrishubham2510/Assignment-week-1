package com.grooming.assignment.week1.q2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.grooming.assignment.week1.q2.drivers.TestInput;
import com.grooming.assignment.week1.q2.entity.User;
import com.grooming.assignment.week1.q2.messages.Message;

@SpringBootTest
public class Tests {
    
    private TestInput testInput;
    private String name,aadhar, dateOfBirth;

    Tests(){
      this.testInput = new TestInput();
    }

    @Test
    void testIdealCase(){

         name = "Associate Developement";
         dateOfBirth = "25-03-2004";
         aadhar = "123456789365";

         String expectedMessage = Message.generateUSerName(new User(name, dateOfBirth, aadhar));

         String actualMessage = testInput.testInput(name, dateOfBirth, aadhar);

         assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void test_InvalidName_emptyName(){

         name = "  ";
         dateOfBirth = "25-03-2004";
         aadhar = "123456789365";

         String expectedMessage = Message.NAME_NOT_VALID_MESSAGE;

         String actualMessage = testInput.testInput(name, dateOfBirth, aadhar);

         assertEquals(expectedMessage, actualMessage);

    }
   
    @Test
    void test_InvalidName_alphanumeric(){

         name = "Associate Develo45per";
         dateOfBirth = "25-03-2004";
         aadhar = "123456789365";

         String expectedMessage = Message.NAME_NOT_VALID_MESSAGE;

         String actualMessage = testInput.testInput(name, dateOfBirth, aadhar);

         assertEquals(expectedMessage, actualMessage);

    }
   
    @Test
    void test_InvalidName_WithMiddleName(){

         name = "Associate Software Developer";
         dateOfBirth = "25-03-2004";
         aadhar = "123456789365";

         String expectedMessage = Message.ONLY_ENTER_FIRST_LAST_NAME;

         String actualMessage = testInput.testInput(name, dateOfBirth, aadhar);

         assertEquals(expectedMessage, actualMessage);

    }
   
    @Test
    void test_InvalidName_WithUnconventionalSpaces(){

         name = "Associate       Software     Developer    ";
         dateOfBirth = "25-03-2004";
         aadhar = "123456789365";

         String expectedMessage = Message.ONLY_ENTER_FIRST_LAST_NAME;

         String actualMessage = testInput.testInput(name, dateOfBirth, aadhar);

         assertEquals(expectedMessage, actualMessage);

    }
   
    @Test
    void test_InvalidName_WithUnconventionalSpaces_OnlyFirst_LastNames(){

         name = "Associate       Software        ";
         dateOfBirth = "25-03-2004";
         aadhar = "123456789365";

         String expectedMessage = Message.generateUSerName(new User(name, dateOfBirth, aadhar));

         String actualMessage = testInput.testInput(name, dateOfBirth, aadhar);

         assertEquals(expectedMessage, actualMessage);

    }
   
    @Test
    void test_InvalidName_TooShort(){

         name = "A D";
         dateOfBirth = "25-03-2004";
         aadhar = "123456789365";

         String expectedMessage = Message.NAME_TOO_SHORT;

         String actualMessage = testInput.testInput(name, dateOfBirth, aadhar);

         assertEquals(expectedMessage, actualMessage);
    }
   
    @Test
    void test_InvalidDateOfBirth_LessThan18(){

         name = "Associate Developer";
         dateOfBirth = "25-03-2010";
         aadhar = "123456789365";

         String expectedMessage = Message.DOB_INVALID_MESSAGE;

         String actualMessage = testInput.testInput(name, dateOfBirth, aadhar);

         assertEquals(expectedMessage, actualMessage);
    }
   
    @Test
    void test_DateOfBirth_Atleast18(){

         name = "Associate Developer ";
         dateOfBirth = "25-03-2005";
         aadhar = "123456789365";

         String expectedMessage = Message.generateUSerName(new User(name, dateOfBirth, aadhar));

         String actualMessage = testInput.testInput(name, dateOfBirth, aadhar);

         assertEquals(expectedMessage, actualMessage);
    }


    @Test
    void test_InvalidAadhar_LenghtMoreThan12(){

         name = "Associate Developer";
         dateOfBirth = "25-03-2005";
         aadhar = "1234567893653";

         String expectedMessage = Message.AADHAR_INVALID_EXCEPTION_MESSAGE;

         String actualMessage = testInput.testInput(name, dateOfBirth, aadhar);

         assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void test_InvalidAadhar_SpecialCharacter(){

         name = "Associate Developer ";
         dateOfBirth = "25-03-2005";
         aadhar = "12345678936#";

         String expectedMessage = Message.AADHAR_INVALID_EXCEPTION_MESSAGE;

         String actualMessage = testInput.testInput(name, dateOfBirth, aadhar);

         assertEquals(expectedMessage, actualMessage);
    }



    
}
