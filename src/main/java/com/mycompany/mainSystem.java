/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import com.mycompany.loginsystem.RegistrationSystem;
import com.mycompany.loginsystem.LoginSystem; 

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
    public User(String firstName, String lastName, String username, String password, String cellPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }
 
    // Default constructor
    public User() {}
 
    // ─────────────────────────────────────────────
    // Validation Methods
    // ─────────────────────────────────────────────
 
    /**
     * Checks that the username contains an underscore and is no more than 5 characters long.
     *
     * @return true if username is valid, false otherwise
     */
    public boolean checkUserName() {
        if (username == null) return false;
        return username.contains("_") && username.length() <= 5;
    }
 
    /**
     * Checks password complexity:
     * - At least 8 characters long
     * - Contains a capital letter
     * - Contains a number
     * - Contains a special character
     *
     * @return true if password meets all complexity rules, false otherwise
     */
    public boolean checkPasswordComplexity() {
        if (password == null || password.length() < 8) return false;
 
        boolean hasUpper   = password.chars().anyMatch(Character::isUpperCase);
        boolean hasDigit   = password.chars().anyMatch(Character::isDigit);
        boolean hasSpecial = password.chars().anyMatch(c -> !Character.isLetterOrDigit(c));
 
        return hasUpper && hasDigit && hasSpecial;
    }
 
    /**
     * Validates a South African cell phone number.
     *
     * The number must start with the South African international code (+27)
     * followed by no more than 10 digits (total string no more than 13 chars).
     *
     * Regex reference:
     *   Pattern adapted from: https://regexr.com/39p6e (General phone validation)
     *   South African format reference: https://en.wikipedia.org/wiki/Telephone_numbers_in_South_Africa
     *   The pattern ensures the number starts with +27 and is followed by 9 digits.
     *
     * @return true if cell phone number is valid, false otherwise
     */
    public boolean checkCellPhoneNumber() {
        if (cellPhoneNumber == null) return false;
        // Matches +27 followed by exactly 9 digits (total 12 characters)
        return cellPhoneNumber.matches("^\\+27[0-9]{9}$");
    }
 
    // ─────────────────────────────────────────────
    // Registration Method
    // ─────────────────────────────────────────────
 
    /**
     * Registers the user and returns an appropriate message based on validation results.
     *
     * @return A string message indicating the registration status.
     */
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username " +
                   "contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password " +
                   "contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber()) {
            return "Cell number is incorrectly formatted or does not contain an international code; " +
                   "please correct the number and try again.";
        }
        return "Username successfully captured. Password successfully captured. Cell phone number successfully added.";
    }
 
    // ─────────────────────────────────────────────
    // Login Methods
    // ─────────────────────────────────────────────
 
    /**
     * Verifies login credentials against stored user details.
     *
     * @param enteredUsername the username entered at login
     * @param enteredPassword the password entered at login
     * @return true if credentials match, false otherwise
     */
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        if (enteredUsername == null || enteredPassword == null) return false;
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }
 
    /**
     * Returns the appropriate login status message.
     *
     * @param enteredUsername the username entered at login
     * @param enteredPassword the password entered at login
     * @return A welcome message if successful, or an error message if not.
     */
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
 
    // ─────────────────────────────────────────────
    // Getters & Setters
    // ─────────────────────────────────────────────
 
    public void setUsername(String username)           { this.username = username; }
    public void setPassword(String password)           { this.password = password; }
    public void setCellPhoneNumber(String number)      { this.cellPhoneNumber = number; }
    public void setFirstName(String firstName)         { this.firstName = firstName; }
    public void setLastName(String lastName)           { this.lastName = lastName; }
 
    public String getUsername()        { return username; }
    public String getPassword()        { return password; }
    public String getCellPhoneNumber() { return cellPhoneNumber; }
    public String getFirstName()       { return firstName; }
    public String getLastName()        { return lastName; }
}
 