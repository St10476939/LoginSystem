package com.mycompany.loginsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrationSystemTest {

    private RegistrationSystem registration;

    @BeforeEach
    void setUp() {
        registration = new RegistrationSystem();
    }

    // --- checkUserName ---

    @Test
    void testCheckUserName_ValidUsername() {
        assertTrue(registration.checkUserName("jo_n"));
    }

    @Test
    void testCheckUserName_NoUnderscore() {
        assertFalse(registration.checkUserName("john1"));
    }

    @Test
    void testCheckUserName_TooLong() {
        assertFalse(registration.checkUserName("john_doe"));
    }

    @Test
    void testCheckUserName_ExactlyFiveCharsWithUnderscore() {
        assertTrue(registration.checkUserName("jo_ny"));
    }

    // --- checkPasswordComplexity ---

    @Test
    void testCheckPasswordComplexity_ValidPassword() {
        assertTrue(registration.checkPasswordComplexity("Password1!"));
    }

    @Test
    void testCheckPasswordComplexity_NoUppercase() {
        assertFalse(registration.checkPasswordComplexity("password1!"));
    }

    @Test
    void testCheckPasswordComplexity_NoDigit() {
        assertFalse(registration.checkPasswordComplexity("Password!!"));
    }

    @Test
    void testCheckPasswordComplexity_NoSpecialChar() {
        assertFalse(registration.checkPasswordComplexity("Password1"));
    }

    @Test
    void testCheckPasswordComplexity_TooShort() {
        assertFalse(registration.checkPasswordComplexity("Pa1!"));
    }

    // --- checkCellPhoneNumber ---

    @Test
    void testCheckCellPhoneNumber_ValidSANumber() {
        assertTrue(registration.checkCellPhoneNumber("+27821234567"));
    }

    @Test
    void testCheckCellPhoneNumber_MissingPlus() {
        assertFalse(registration.checkCellPhoneNumber("27821234567"));
    }

    @Test
    void testCheckCellPhoneNumber_TooShort() {
        assertFalse(registration.checkCellPhoneNumber("+2782"));
    }

    @Test
    void testCheckCellPhoneNumber_ContainsLetters() {
        assertFalse(registration.checkCellPhoneNumber("+27abc123456"));
    }

    // --- registerUser ---

    @Test
    void testRegisterUser_AllValid() {
        String result = registration.registerUser("jo_ny", "Password1!", "+27821234567", "John", "Doe");
        assertEquals("Registration successful!", result);
    }

    @Test
    void testRegisterUser_InvalidUsername() {
        String result = registration.registerUser("johnathan", "Password1!", "+27821234567", "John", "Doe");
        assertTrue(result.contains("Username is not correctly formatted"));
    }

    @Test
    void testRegisterUser_InvalidPassword() {
        String result = registration.registerUser("jo_ny", "weakpass", "+27821234567", "John", "Doe");
        assertTrue(result.contains("Password is not correctly formatted"));
    }

    @Test
    void testRegisterUser_InvalidPhone() {
        String result = registration.registerUser("jo_ny", "Password1!", "0821234567", "John", "Doe");
        assertTrue(result.contains("Cell phone number incorrectly formatted"));
    }
}