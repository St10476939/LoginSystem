/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.loginsystem;

import com.mycompany.mainSystem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class Login {
   
   // Create an instance of the logic class, not the test class
    mainSystem user = new mainSystem();

    @Test
    public void testLoginSuccess() {
        // Prepare the user data
        user.setUsername("kyl_1");
        user.setPassword("Ch&&sec@ke99!");
        
        // Test if login returns true for matching credentials
        assertTrue(user.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFail() {
        // Prepare the user data
        user.setUsername("kyl_1");
        user.setPassword("Ch&&sec@ke99!");
        
        // Test if login returns false for incorrect password
        assertFalse(user.loginUser("kyl_1", "wrongPassword"));
    }

    @Test
    public void testLoginMessageSuccess() {
        // Prepare names for the welcome message
        user.setFirstName("Kyle");
        user.setLastName("Smith");
        
        // Test the message when login is successful (true)
        String expected = "Welcome Kyle, Smith it is great to see you again.";
        String actual = user.returnLoginStatus(true);
        
        assertEquals(expected, actual);
    }

    @Test
    public void testLoginMessageFail() {
        // Test the message when login fails (false)
        String expected = "Username or password incorrect, please try again.";
        String actual = user.returnLoginStatus(false);
        
        assertEquals(expected, actual);
    }
}    
    

