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
public class Login {
   
    Login user = new Login();

    @Test
    public void testLoginSuccess() {
        user.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(user.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFail() {
        user.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertFalse(user.loginUser("kyl_1", "wrongPassword"));
    }

    @Test
    public void testLoginMessageSuccess() {
        user.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        String message = user.returnLoginStatus(true);
        assertEquals("Welcome Kyle, Smith it is great to see you again.", message);
    }

    @Test
    public void testLoginMessageFail() {
        String message = user.returnLoginStatus(false);
        assertEquals("Username or password incorrect, please try again.", message);
    }
}
    
    

