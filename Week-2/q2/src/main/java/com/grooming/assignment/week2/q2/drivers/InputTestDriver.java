package com.grooming.assignment.week2.q2.drivers;

import java.io.BufferedReader;
import java.io.FileReader;

import com.grooming.assignment.week2.q2.entity.Employee;
import com.grooming.assignment.week2.q2.services.EmployeeService;

public class InputTestDriver {

    public String testInput(String name, String dateOfJoininig, String employmentType, String roleType, String domainType){
        String message = "Successfully Processed";
        try {
            Employee employee = new Employee(name, dateOfJoininig, employmentType, roleType, domainType);
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        return message;
    } 

    // function to parse input file
    public void processInput(String fileName) throws Exception{
        
        EmployeeService employeeService = new EmployeeService();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();

        while(line!=null){
           /*
                input in the file is ',' separated. Hence, splitting the line based on ',' character 
           */

           String[] employeeInfo = line.split(",");
        
           employeeService.addEmployee(employeeInfo[0],employeeInfo[1],employeeInfo[2],employeeInfo[3],employeeInfo[4]);
          
           line = bufferedReader.readLine(); 
        }

        fileName = "commands.txt";

        fileReader.close();

        fileReader = new FileReader(fileName);
        bufferedReader = new BufferedReader(fileReader);
        line = bufferedReader.readLine();

        while(line!=null){
           /*
                input in the file is ',' separated. Hence, splitting the line based on ',' character 
           */

          
          String[] employeeInfo = line.split(",");

           if(employeeInfo.length==1)
              employeeService.displayAllEmployees();  

           else if(isNumber(employeeInfo[1])){
            
             switch(employeeInfo[0]){
                case "display": employeeService.displayEmployeeDetails(employeeInfo[1]);
                                break;
                case "all employees": employeeService.getAllEmployees(Long.parseLong(employeeInfo[1]));
                                      break;
                default: throw new UnsupportedOperationException("The command is not recognised, please check and try again");                      

             }
           }else{
              employeeService.getAllEmployees(employeeInfo[1]);
           }      
           
           line = bufferedReader.readLine(); 
        }

        bufferedReader.close();
        fileReader.close();
    }

    // function to test the input file
    // public void testServices() throws Exception{
        
    //     String fileName = "commands.txt";
    //     EmployeeService employeeService = new EmployeeService();

    //     FileReader fileReader = new FileReader(fileName);
    //     BufferedReader bufferedReader = new BufferedReader(fileReader);
    //     String line = bufferedReader.readLine();

    //     while(line!=null){
    //        /*
    //             input in the file is ',' separated. Hence, splitting the line based on ',' character 
    //        */

          
    //       String[] employeeInfo = line.split(",");

    //        if(employeeInfo.length==1)
    //           employeeService.displayAllEmployees();  

    //        else if(isNumber(employeeInfo[1])){
            
    //          switch(employeeInfo[0]){
    //             case "display": employeeService.displayEmployeeDetails(employeeInfo[1]);
    //                             break;
    //             case "all employees": employeeService.getAllEmployees(Long.parseLong(employeeInfo[1]));
    //                                   break;
    //             default: throw new UnsupportedOperationException("The command is not recognised, please check and try again");                      

    //          }
    //        }else{
    //           employeeService.getAllEmployees(employeeInfo[1]);
    //        }      
           
    //        line = bufferedReader.readLine(); 
    //     }

    //     bufferedReader.close();
    //     fileReader.close();
    // }
    

    private boolean isNumber(String str){
  
        boolean result = true;

        try {
            Long.parseLong(str);
        } catch (Exception e) {
            result = false;
        }
         
        return result;
    }

}
