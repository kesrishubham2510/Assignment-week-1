package q1;

import java.util.Scanner;

import q1.entity.JobApplicant;
import q1.messages.Message;

public class driver {
    public static void main(String[] args) {
        Scanner scannerObj = new Scanner(System.in);
        
        String firstname,lastName, techStack,currentPackage;
        float yearsOfExperience;


        System.out.println("Please Enter your first Name");
        firstname = scannerObj.nextLine();
        System.out.println("Please Enter your last Name (Optional)");
        lastName = scannerObj.nextLine();
        System.out.println("Please Enter your tech stack");
        techStack = scannerObj.nextLine();
        System.out.println("Please Enter your current package");
        currentPackage = scannerObj.nextLine(); 
        System.out.println("Please Enter your years of experience");
        yearsOfExperience = scannerObj.nextFloat();
        // scannerObj.next();
        
        try {
          
            JobApplicant jobApplicant = new JobApplicant(firstname, lastName, techStack, yearsOfExperience,currentPackage);
            Message.getExpectedSalaryMessage(jobApplicant.getTechStack(), jobApplicant.getCurrentPackage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}
