/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.loginsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class Password {
    
    // Create an instance of the class that contains the logic
    Password user = new Password();

    @Test
    public void testPasswordComplexitySuccess() {
        // Test Data: "Ch&&sec@ke99!"
        user.setPassword("Ch&&sec@ke99!");
        assertTrue(user.checkPasswordComplexity(), "Password should meet complexity requirements.");
    }

    @Test
    public void testPasswordComplexityFailure() {
        // Test Data: "password"
        user.setPassword("password");
        assertFalse(user.checkPasswordComplexity(), "Password should fail complexity requirements.");
    }
    
    @Test
    public void testUsernameSuccess() {
        // Test Data: "kyl_1"
        user.setUsername("kyl_1");
        assertTrue(user.checkUserName());
    }
    
    @Test
    public void testUsernameFailure() {
        // Test Data: "kyle!!!!!!!"
        user.setUsername("kyle!!!!!!!");
        assertFalse(user.checkUserName());
    }
}