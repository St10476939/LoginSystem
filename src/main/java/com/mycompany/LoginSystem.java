/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
 
/**
 * Main application class for the Registration and Login system.
 * Demonstrates user registration and login functionality.
 */
public class LoginSystem {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("User Registration & Login System");
 
        //  Registration 
        System.out.println("Registration");
 
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine().trim();
 
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine().trim();
 
        System.out.print("Enter username (must contain '_' and be ≤5 characters): ");
        String username = scanner.nextLine().trim();
 
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();
 
        System.out.print("Enter cell phone number (e.g. +27838968976): ");
        String cellPhone = scanner.nextLine().trim();
 
        // Create user and run registration
        User user = new User(firstName, lastName, username, password, cellPhone);
 
        // Individual field feedback
        if (user.checkUserName()) {
            System.out.println(" Username successfully captured.");
        } else {
            System.out.println(" Username is not correctly formatted; please ensure that your username " +
                    "contains an underscore and is no more than five characters in length.");
        }
 
        if (user.checkPasswordComplexity()) {
            System.out.println(" Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password " +
                    "contains at least eight characters, a capital letter, a number, and a special character.");
        }
 
        if (user.checkCellPhoneNumber()) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println("Cell number is incorrectly formatted or does not contain an international code; " +
                    "please correct the number and try again.");
        }
 
        String registrationResult = user.registerUser();
        System.out.println("\nRegistration result: " + registrationResult);
 
        // Only attempt login if registration succeeded
        if (!user.checkUserName() || !user.checkPasswordComplexity() || !user.checkCellPhoneNumber()) {
            System.out.println("\nRegistration failed. Please fix the errors above and try again.");
            scanner.close();
            return;
        }
 
        //  Login 
        System.out.println("\n--- Login ---");
 
        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine().trim();
 
        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine().trim();
 
        String loginStatus = user.returnLoginStatus(loginUsername, loginPassword);
        System.out.println(loginStatus);
 
        scanner.close();
    }
}