package com.grooming.assignment.week2.q1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.grooming.assignment.week2.q1.config.Constant;
import com.grooming.assignment.week2.q1.drivers.InputTestDriver;

@SpringBootTest
public class EmployeeValidationTest {

    private InputTestDriver inputTestDriver;
    private String name;
    private String dateOfJoininig;
    private String employmentType;
    private String roleType;
    private String statusType;

    EmployeeValidationTest() {
        inputTestDriver = new InputTestDriver();
    }

    @Test
    void testValidEmployee() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2018";
        employmentType = "Full time";
        roleType = "Associate";
        statusType = "active";

        String expectedMessage = "Successfully Processed";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, statusType);
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void testValidEmploymentType_Contract() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2018";
        employmentType = "Contract";
        roleType = "Associate";
        statusType = "active";

        String expectedMessage = "Successfully Processed";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, statusType);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testValidEmployment_FullTime() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2018";
        employmentType = "Full time";
        roleType = "Associate";
        statusType = "active";

        String expectedMessage = "Successfully Processed";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, statusType);
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void testValidRole_Associate() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2018";
        employmentType = "Full time";
        roleType = "Associate";
        statusType = "active";

        String expectedMessage = "Successfully Processed";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, statusType);
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void testValidRole_SeniorAssociate() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2018";
        employmentType = "Full time";
        roleType = "Senior Associate";
        statusType = "active";

        String expectedMessage = "Successfully Processed";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, statusType);
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void testValidStatus_Active() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2018";
        employmentType = "Full time";
        roleType = "Associate";
        statusType = "active";

        String expectedMessage = "Successfully Processed";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, statusType);
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void testValidStatus_ServingNotice() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2018";
        employmentType = "Full time";
        roleType = "Associate";
        statusType = "serving notice";

        String expectedMessage = "Successfully Processed";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, statusType);
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void testValidStatus_Exit() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2018";
        employmentType = "Full time";
        roleType = "Associate";
        statusType = "exit";

        String expectedMessage = "Successfully Processed";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, statusType);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testInvalidDateException_WrongDate() {

        name = "Programmer 1";
        dateOfJoininig = "23-81-2018";
        employmentType = "Full time";
        roleType = "Associate";
        statusType = "exit";

        String expectedMessage = Constant.DATE_FORMAT_EXCEPTION_MESSAGE;

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, statusType);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testInvalidDateException_FutureDate() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2028";
        employmentType = "Full time";
        roleType = "Associate";
        statusType = "exit";

        String expectedMessage = Constant.INVALID_DATE_EXCEPTION_MESSAGE;

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, statusType);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testInvalidEnumerationType_EmploymentType() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2008";
        employmentType = "I don't know";
        roleType = "Associate";
        statusType = "active";

        String expectedMessage = "Please enter a valid EMPLOYMENT_TYPE, you can choose from [ Contract, Full time ] values. Make sure you only have a single space between two words.";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, statusType);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testInvalidEnumerationType_RoleType() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2008";
        employmentType = "Full time";
        roleType = "Associate -1";
        statusType = "active";

        String expectedMessage = "Please enter a valid ROLE, you can choose from [ Associate, Senior Associate ] values. Make sure you only have a single space between two words.";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, statusType);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testInvalidEnumerationType_StatusType() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2008";
        employmentType = "Full time";
        roleType = "Associate";
        statusType = "last seen 6 momths ago";

        String expectedMessage = "Please enter a valid STATUS, you can choose from [ Active, Left, On Notice Period ] values. Make sure you only have a single space between two words.";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, statusType);
        assertEquals(expectedMessage, actualMessage);
    }

}
