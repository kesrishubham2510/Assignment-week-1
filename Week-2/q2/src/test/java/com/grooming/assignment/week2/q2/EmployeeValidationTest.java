package com.grooming.assignment.week2.q2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.grooming.assignment.week2.q2.config.Constant;
import com.grooming.assignment.week2.q2.drivers.InputTestDriver;

@SpringBootTest
public class EmployeeValidationTest {

    private InputTestDriver inputTestDriver;
    private String name;
    private String dateOfJoininig;
    private String employmentType;
    private String roleType;
    private String domainType;

    EmployeeValidationTest() {
        inputTestDriver = new InputTestDriver();
    }

    @Test
    void testValidEmployee() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2018";
        employmentType = "Full time";
        roleType = "Associate";
        domainType = "development";

        String expectedMessage = "Successfully Processed";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, domainType);
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void testValidEmploymentType_Contract() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2018";
        employmentType = "Contract";
        roleType = "Associate";
        domainType = "development";

        String expectedMessage = "Successfully Processed";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, domainType);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testValidEmployment_FullTime() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2018";
        employmentType = "Full time";
        roleType = "Associate";
        domainType = "development";

        String expectedMessage = "Successfully Processed";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, domainType);
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void testValidRole_Associate() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2018";
        employmentType = "Full time";
        roleType = "Associate";
        domainType = "development";

        String expectedMessage = "Successfully Processed";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, domainType);
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void testValidRole_SeniorAssociate() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2018";
        employmentType = "Full time";
        roleType = "Senior Associate";
        domainType = "development";

        String expectedMessage = "Successfully Processed";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, domainType);
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void testValidStatus_Active() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2018";
        employmentType = "Full time";
        roleType = "Associate";
        domainType = "development";

        String expectedMessage = "Successfully Processed";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, domainType);
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void testValidDomain_Development() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2018";
        employmentType = "Full time";
        roleType = "Associate";
        domainType = "development";

        String expectedMessage = "Successfully Processed";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, domainType);
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void testValidDomain_Analysis() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2018";
        employmentType = "Full time";
        roleType = "Associate";
        domainType = "analySis";

        String expectedMessage = "Successfully Processed";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, domainType);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testValidDomain_Accounts() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2018";
        employmentType = "Full time";
        roleType = "Associate";
        domainType = "accounTS";

        String expectedMessage = "Successfully Processed";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, domainType);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testInvalidDateException_WrongDate() {

        name = "Programmer 1";
        dateOfJoininig = "23-81-2018";
        employmentType = "Full time";
        roleType = "Associate";
        domainType = "exit";

        String expectedMessage = Constant.DATE_FORMAT_EXCEPTION_MESSAGE;

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, domainType);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testInvalidDateException_FutureDate() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2028";
        employmentType = "Full time";
        roleType = "Associate";
        domainType = "exit";

        String expectedMessage = Constant.INVALID_DATE_EXCEPTION_MESSAGE;

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, domainType);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testInvalidEnumerationType_EmploymentType() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2008";
        employmentType = "I don't know";
        roleType = "Associate";
        domainType = "active";

        String expectedMessage = "Please enter a valid EMPLOYMENT_TYPE, you can choose from [ Contract, Full time ] values. Make sure you only have a single space between two words.";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, domainType);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testInvalidEnumerationType_RoleType() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2008";
        employmentType = "Full time";
        roleType = "Associate -1";
        domainType = "active";

        String expectedMessage = "Please enter a valid ROLE, you can choose from [ Associate, Senior Associate ] values. Make sure you only have a single space between two words.";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, domainType);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testInvalidEnumerationType_StatusType() {

        name = "Programmer 1";
        dateOfJoininig = "23-01-2008";
        employmentType = "Full time";
        roleType = "Associate";
        domainType = "last seen 6 momths ago";

        String expectedMessage = "Please enter a valid DOMAIN, you can choose from [ Development, Analysis, Accounts ] values. Make sure you only have a single space between two words.";

        String actualMessage = inputTestDriver.testInput(name, dateOfJoininig, employmentType, roleType, domainType);
        assertEquals(expectedMessage, actualMessage);
    }

}
