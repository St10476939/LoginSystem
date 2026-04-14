/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import com.mycompany.loginsystem.MainSystem; 

import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class mainSystem { 
    
     private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    // Constructor
    public mainSystem(String firstName, String lastName, String username, String password, String cellPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    // Default constructor
    public mainSystem ()()

    // Username validation
    public boolean checkUserName() {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    // Password validation
    public boolean checkPasswordComplexity() {
        if (password == null || password.length() < 8) return false;

        boolean hasUpper = password.chars().anyMatch(Character::isUpperCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasSpecial = password.chars().anyMatch(c -> !Character.isLetterOrDigit(c));

        return hasUpper && hasDigit && hasSpecial;
    }

    // Phone validation
    public boolean checkCellPhoneNumber() {
        return cellPhoneNumber != null && cellPhoneNumber.matches("^\\+27[0-9]{9}$");
    }

    // Register user
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted.";
        }

        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted.";
        }

        if (!checkCellPhoneNumber()) {
            return "Cell number is incorrectly formatted.";
        }

        return "Registration successful!";
    }

    // Login
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) &&
               this.password.equals(enteredPassword);
    }

    // Login message
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + " " + lastName;
        }
        return "Username or password incorrect.";
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        mainSystem user = new mainSystem();

        System.out.println("=== REGISTER ===");

        System.out.print("First Name: ");
        user.setFirstName(input.nextLine());

        System.out.print("Last Name: ");
        user.setLastName(input.nextLine());

        System.out.print("Username: ");
        user.setUsername(input.nextLine());

        System.out.print("Password: ");
        user.setPassword(input.nextLine());

        System.out.print("Phone (+27...): ");
        user.setCellPhoneNumber(input.nextLine());

        String result = user.registerUser();
        System.out.println(result);

        if (result.equals("Registration successful!")) {

            System.out.println("\n=== LOGIN ===");

            System.out.print("Username: ");
            String u = input.nextLine();

            System.out.print("Password: ");
            String p = input.nextLine();

            System.out.println(user.returnLoginStatus(u, p));
        }

        input.close();
    }

    // Setters
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setCellPhoneNumber(String number) { this.cellPhoneNumber = number; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
}