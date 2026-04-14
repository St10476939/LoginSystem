/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class MainSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RegistrationSystem registration = new RegistrationSystem();

        System.out.println("Register");
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();
        System.out.print("Enter SA phone number +27...: ");
        String phone = input.nextLine();

        String registerMessage = registration.registerUser(username, password, phone, firstName, lastName);
        System.out.println(registerMessage);

        if (registerMessage.equals("Registration successful!")) {
            MainSystem user = new User(firstName, lastName, username, password, phone);
            LoginSystem loginSystem = new LoginSystem(user);

            System.out.println("\nLogin");
            System.out.print("Enter username: ");
            String loginUser = input.nextLine();
            System.out.print("Enter password: ");
            String loginPass = input.nextLine();

            boolean loginStatus = loginSystem.loginUser(loginUser, loginPass);
            System.out.println(loginSystem.returnLoginStatus(loginStatus));
        }

        input.close();
    }
}