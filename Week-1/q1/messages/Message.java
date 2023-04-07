package q1.messages;

import q1.enums.TECH_STACK;

public class Message {
    public static String EXP_NOT_ENOUGH_MESSAGE = "Your experience does not qualify for the job. Minimum required experience for the role of %s is %s"; 
    public static String EXPECTED_SALARY_MESSAGE = "You're qualified for the role of %s. You can expect a salary of %s "; 
    public static String NAME_NOT_VALID_MESSAGE = "Name should not contain any digits or special characters or empty or whitespaces";
    public static String TECHSTACK_NOT_VALID_MESSAGE = "Please enter a job role from %s only";
    public static String PACKAGE_NOT_VALID_EXCEPTION = "Please enter a correct package"; 


    public static String getExperienceExceptionMessage(TECH_STACK techStack){
           return String.format(EXP_NOT_ENOUGH_MESSAGE, techStack.getOfferedRole(),techStack.getMinExperience());
    }
    
    public static String getExpectedSalaryMessage(TECH_STACK techStack, int currentPackage){
           return String.format(EXPECTED_SALARY_MESSAGE, techStack.getOfferedRole().toString(),(currentPackage*techStack.getExpectedSalaryFactor()));
    }

    public static String getRoleNotValidExceptionMessage(TECH_STACK[] techStack){
        StringBuilder strBuilder = new StringBuilder("[ ");
        int i,len = techStack.length;
        i=0;

        for(;i<len-1;i++){
            strBuilder.append(techStack[i].toString()+", ");
        }

        strBuilder.append(techStack[i].toString()+" ]");

        return String.format(TECHSTACK_NOT_VALID_MESSAGE, strBuilder.toString());
    }
}
