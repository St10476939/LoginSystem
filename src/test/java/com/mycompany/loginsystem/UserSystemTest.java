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

public class UserSystemTest {

    private User instance;

    public UserSystemTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        // Create a real User instance before each test
        instance = new User("jo_n", "Password1!", "+27821234567", "John", "Doe");
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        String expResult = "jo_n";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String expResult = "Password1!";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCellphone() {
        System.out.println("getCellphone");
        String expResult = "+27821234567";
        String result = instance.getCellphone();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "John";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "Doe";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }
}