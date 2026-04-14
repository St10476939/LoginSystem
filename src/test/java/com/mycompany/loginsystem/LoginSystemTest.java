package com.mycompany.loginsystem;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginSystemTest {

    private LoginSystem loginSystem;

    @BeforeEach
    void setUp() {
        LoginSystem user = new User("John", "Doe", "jo_ny", "Password1!", "+27821234567");
        loginSystem = new LoginSystem(user);
    }

    //loginUser

    @Test
    void testLoginUser_CorrectCredentials() {
        assertTrue(loginSystem.loginUser("jony", "Password1!"));
    }

    @Test
    void testLoginUser_WrongPassword() {
        assertFalse(loginSystem.loginUser("jo_ny", "WrongPass1!"));
    }

    @Test
    void testLoginUser_WrongUsername() {
        assertFalse(loginSystem.loginUser("wrong", "Password1!"));
    }

    @Test
    void testLoginUser_BothWrong() {
        assertFalse(loginSystem.loginUser("wrong", "wrongpass"));
    }

    @Test
    void testLoginUser_EmptyCredentials() {
        assertFalse(loginSystem.loginUser("", ""));
    }

    //returnLoginStatus

    @Test
    void testReturnLoginStatus_True() {
        String result = loginSystem.returnLoginStatus(true);
        assertEquals("Welcome John, Doe it is great to see you again.", result);
    }

    @Test
    void testReturnLoginStatus_False() {
        String result = loginSystem.returnLoginStatus(false);
        assertEquals("Username or password incorrect, please try again.", result);
    }
}