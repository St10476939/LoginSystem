/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

// Make sure to import your User class if it's in a different package
// import com.mycompany.User; 

/**
 *
 * @author lab_services_student
 */
public class LoginSystem {
    
    private User user;

    // FIXED: Constructor name must match the Class name exactly
    public LoginSystem(User user) {
        this.user = user;
    }

    // Check login
    public boolean loginUser(String username, String password) {
        // Added a null check to prevent a NullPointerException if username/password is empty
        if (username == null || password == null) {
            return false;
        }
        return user.getUsername().equals(username) &&
               user.getPassword().equals(password);
    }

    // Return message
    public String returnLoginStatus(boolean status) {
        if (status) {
            return "Welcome " + user.getFirstName() + ", " + user.getLastName() + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}