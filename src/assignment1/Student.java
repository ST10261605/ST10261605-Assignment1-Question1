/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sami
 */
public class Student { 
    
    int stID, stAge;
    String stName, stEmail, stCourse; 

    public int getStID() {
        return stID;
    }

    public void setStID(int stID) {
        this.stID = stID;
    }

    public int getStAge() {
        return stAge;
    }

    public void setStAge(int stAge) {
        this.stAge = stAge;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStEmail() {
        return stEmail;
    }

    public void setStEmail(String stEmail) {
        this.stEmail = stEmail;
    }

    public String getStCourse() {
        return stCourse;
    }

    public void setStCourse(String stCourse) {
        this.stCourse = stCourse;
    }
    
    String firstMenuChoice; 
     int secondMenuChoice; 
     final Scanner kb = new Scanner(System.in);
    
    final static ArrayList <Integer> studentID = new ArrayList<>(); 
    final static ArrayList <String> studentName = new ArrayList<>();
    final static  ArrayList <Integer> studentAge = new ArrayList<>(); 
    final static ArrayList <String> studentEmail = new ArrayList<>(); 
    final static ArrayList <String> studentCourse = new ArrayList<>(); 
 
    public void Menu() {
        
        System.out.println("STUDENT MANAGEMENT APPLICATION" + "\n" 
                                      + "**************************************" + "\n"
                                      + "Enter (1) to launch the menu or any other key to exit");
        
        
        firstMenuChoice = kb.next();
        if (!firstMenuChoice.equals("1")){
            System.out.println("Exiting....");
            System.exit(0); 
        } else {
            System.out.println("Please select one of the following menu items: " + "\n"
                                         + "(1) Capture a new student." + "\n" 
                                         + "(2) Search for a student." + "\n"
                                         + "(3) Delete a student." + "\n" 
                                         + "(4) Print student report" + "\n"
                                         + "(5) Exit application" ); 
            
             secondMenuChoice = kb.nextInt();            
             
             switch (secondMenuChoice) {
                 case 1: saveStudent(); break; 
                 case 2: searchStudent(); break; 
                 case 3: deleteStudent(); break; 
                 case 4: studentReport(); break; 
                 case 5: exitStudentApplication(); break; 
                 default: System.out.println("Invalid menu choice"); break;                  
             }
        }     
    }
    
    public void saveStudent() {
                      
            System.out.println("CAPTURE A NEW STUDENT"); 
            System.out.println("*************************" + "\n");
            
            System.out.println("Enter the student ID: ");
            int studID = kb.nextInt(); 
        //    setStID(studID);
            studentID.add(studID);
         
            kb.nextLine(); 
            
            System.out.println("Enter student name: ");
            String studName = kb.nextLine(); 
       //     setStName(studName);
            studentName.add(studName);
                        
            ageValidation();
                   
            emailValidation();
            
            System.out.println("Enter student course: ");
            String studCourse = kb.nextLine(); 
        //    setStCourse(studCourse);
            studentCourse.add(studCourse);
            
            System.out.println("Student details have been successfully saved");
            Menu();
        }
   
    public void searchStudent() {
        
        System.out.print("Enter student ID to search: ");
        int searchID = kb.nextInt(); 
         kb.nextLine(); 
        
        boolean found = false; //flag to keep track of whether ID is found or not
        
        for (int i = 0; i < studentID.size(); i++) {
            int currentID = studentID.get(i);
            if (searchID == currentID) {
                System.out.println("---------------------------------------------------");
                System.out.println("Student ID: " + studentID.get(i));
                System.out.println("Student name: " + studentName.get(i));
                System.out.println("Student age: " + studentAge.get(i));
                System.out.println("Student email: " + studentEmail.get(i));
                System.out.println("Student course: " + studentCourse.get(i));
                System.out.println("----------------------------------------------------");
                
                found = true; 
                Menu();
                break; //exit loop once ID found
            }
            }
        
        if (!found) {
            System.out.println("Student ID: " + searchID + " was not found!");
        }
    }
    
    public void deleteStudent() {
        
        System.out.print("Enter the student ID to delete: ");
        int deleteID = kb.nextInt(); 
        
        boolean found = false; //flag to keep track of whether the ID was found or not 
        
        kb.nextLine();
        
        for (int i = 0; i < studentID.size(); i++) {
            int currentDelete = studentID.get(i); 
            if (deleteID == currentDelete)  {
                   System.out.println("Are you sure you want to delete student " + deleteID + " from the system? Yes (y) to delete");
                   String userInput = kb.nextLine(); 
                   userInput = userInput.toLowerCase();
                   
                   if (userInput.equals("y")) {
                       studentID.remove(i);
                       studentName.remove(i);
                       studentAge.remove(i);
                       studentEmail.remove(i);
                       studentCourse.remove(i);
                       
                       System.out.println("-------------------------------------------------");
                       System.out.println("Student with student ID " + deleteID + "has been deleted!");
                       found = true; 
                       Menu();
                       break; 
                   } 
            } 
        }
         if (!found) {
                System.out.println("Student ID " + deleteID + " does not exist");
                 Menu(); 
            }
    }
    
    public void ageValidation() {
        int studAge;
        do {                                   
                System.out.println("Enter student age: ");
                if (kb.hasNextInt()) {
                    studAge = kb.nextInt(); 
                    kb.nextLine(); 
                    if (studAge >= 16) {
               //         setStAge(studAge);
                        studentAge.add(studAge);
                        break; //exit loop when valid age entered
                    }
                } else {
                    kb.nextLine(); 
                }
                    System.out.println("You have entered an invalid student age!");
            } while (true); //continue looping until valid age entered
    }
    
    public void emailValidation() {
        String email;
        do {
            System.out.println("Enter student email: ");
             email = kb.nextLine(); 
            if (email.indexOf('@') != -1) {   //if email contains the character '@'
             //   setStEmail(email);
                studentEmail.add(email);
                break; //exit loop once email contains '@'
            } 
            System.out.println("You have entered an invalid email");
        } while (true); //continue looping until valid email entered
    }
    
    public void studentReport() {       
        int count = 1;
        
        for (int i = 0; i < studentID.size(); i++) {
            System.out.println("Student " + count);
            System.out.println("-----------------------------------------");
            System.out.println("Student ID: " + studentID.get(i));
            System.out.println("Student name: " + studentName.get(i));
            System.out.println("Student age: " + studentAge.get(i));
            System.out.println("Student email: " + studentEmail.get(i));
            System.out.println("Student course: " + studentCourse.get(i));
            System.out.println("-------------------------------------------");
            count++;   
        }
            Menu(); 
    }
        
        public void exitStudentApplication() {
        System.out.println("Exiting the application.....");
        System.exit(0);
    }
}
