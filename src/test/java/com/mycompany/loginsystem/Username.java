/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.loginsystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class Username {
    
   private User user;
 
    @BeforeEach
    public void setUp() {
        // Create a base registered user for login tests
        user = new User("John", "Doe", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
    }
 
    // Username Tests
 
    /**
     * Test: Username is correctly formatted.
     * Input: "kyl_1" → contains underscore, ≤5 characters → expected: true
     */
    @Test
    public void testUsernameCorrectlyFormatted() {
        user.setUsername("kyl_1");
        assertTrue(user.checkUserName(),
                "Expected true for valid username 'kyl_1'");
    }
 
    /**
     * Test: Username is incorrectly formatted.
     * Input: "kyle!!!!!!!" → no underscore and >5 characters → expected: false
     */
    @Test
    public void testUsernameIncorrectlyFormatted() {
        user.setUsername("kyle!!!!!!!");
        assertFalse(user.checkUserName(),
                "Expected false for invalid username 'kyle!!!!!!!'");
    }
 
    // Password Tests
 
    /**
     * Test: Password meets complexity requirements.
     * Input: "Ch&&sec@ke99!" → ≥8 chars, has uppercase, number, special char → expected: true
     */
    @Test
    public void testPasswordMeetsComplexity() {
        user.setPassword("Ch&&sec@ke99!");
        assertTrue(user.checkPasswordComplexity(),
                "Expected true for valid password 'Ch&&sec@ke99!'");
    }
 
    /**
     * Test: Password does not meet complexity requirements.
     * Input: "password" → no uppercase, no number, no special char → expected: false
     */
    @Test
    public void testPasswordDoesNotMeetComplexity() {
        user.setPassword("password");
        assertFalse(user.checkPasswordComplexity(),
                "Expected false for invalid password 'password'");
    }
 
    // Cell Phone Number Tests
 
    /**
     * Test: Cell phone number is correctly formatted.
     * Input: "+27838968976" → starts with +27, 9 digits follow → expected: true
     */
    @Test
    public void testCellPhoneCorrectlyFormatted() {
        user.setCellPhoneNumber("+27838968976");
        assertTrue(user.checkCellPhoneNumber(),
                "Expected true for valid cell number '+27838968976'");
    }
 
    /**
     * Test: Cell phone number is incorrectly formatted (no international code).
     * Input: "08966553" → missing +27 and too short → expected: false
     */
    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        user.setCellPhoneNumber("08966553");
        assertFalse(user.checkCellPhoneNumber(),
                "Expected false for invalid cell number '08966553'");
    }
 
    // Registration Message Tests (assertEquals)
 
    /**
     * Test: registerUser() returns correct message for invalid username.
     */
    @Test
    public void testRegisterUserInvalidUsername() {
        user.setUsername("kyle!!!!!!!");
        assertEquals(
            "Username is not correctly formatted; please ensure that your username " +
            "contains an underscore and is no more than five characters in length.",
            user.registerUser()
        );
    }
 
    /**
     * Test: registerUser() returns correct message for invalid password.
     */
    @Test
    public void testRegisterUserInvalidPassword() {
        user.setUsername("kyl_1");
        user.setPassword("password");
        assertEquals(
            "Password is not correctly formatted; please ensure that the password " +
            "contains at least eight characters, a capital letter, a number, and a special character.",
            user.registerUser()
        );
    }
 
    /**
     * Test: registerUser() succeeds when all fields are valid.
     */
    @Test
    public void testRegisterUserSuccess() {
        user.setUsername("kyl_1");
        user.setPassword("Ch&&sec@ke99!");
        user.setCellPhoneNumber("+27838968976");
        assertEquals(
            "Username successfully captured. Password successfully captured. Cell phone number successfully added.",
            user.registerUser()
        );
    }
 
    // Login Tests
 
    /**
     * Test: Login succeeds with correct credentials → expected: true
     */
    @Test
    public void testLoginSuccessful() {
        assertTrue(user.loginUser("kyl_1", "Ch&&sec@ke99!"),
                "Expected true for correct login credentials");
    }
 
    /**
     * Test: Login fails with incorrect credentials → expected: false
     */
    @Test
    public void testLoginFailed() {
        assertFalse(user.loginUser("wrong_user", "wrongpass"),
                "Expected false for incorrect login credentials");
    }
 
    // Return Login Status Message Tests (assertEquals)
 
    /**
     * Test: returnLoginStatus() returns welcome message on successful login.
     */
    @Test
    public void testReturnLoginStatusSuccess() {
        assertEquals(
            "Welcome John, Doe it is great to see you again.",
            user.returnLoginStatus("kyl_1", "Ch&&sec@ke99!")
        );
    }
 
    /**
     * Test: returnLoginStatus() returns error message on failed login.
     */
    @Test
    public void testReturnLoginStatusFailed() {
        assertEquals(
            "Username or password incorrect, please try again.",
            user.returnLoginStatus("wrong_user", "wrongpass")
        );
    }
}
