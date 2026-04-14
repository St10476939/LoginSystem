/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.loginsystem;
/**
 *
 * @author lab_services_student
 */
public class LoginSystem {
    
    private LoginSystem user;
  private User user;

    public LoginSystem(User user) {
        this.user = user;
    }

    public boolean loginUser(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        return user.getUsername().equals(username)
                && user.getPassword().equals(password);
    }

    public String returnLoginStatus(boolean status) {
        if (status) {
            return "Welcome " + user.getFirstName() + ", " 
                   + user.getLastName() + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}