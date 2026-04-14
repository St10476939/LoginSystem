# LoginSystem

# Overview 
## This project is a login and registration system built using Java. I developed it using object-oriented programming principles. The system does the following:
Allows users to register an account
Checks their details like username, password and phone number
 Lets users log in using their stored credentials

## Objectives
## By the end of this project the system will be able to:

* Create and use classes, methods and objects

* Make decisions using if statements

* Get input from users and produce output

* Check user data using expressions

* Apply object-oriented concepts like encapsulation

# System Structure

The application has four classes:

# 1. User.java

## This class stores user information like:

* Username

* Password

* Cellphone number

* First name

* Last name

It uses methods to access data.

# 2. Registration.java

## This class handles:

* Checking if usernames are valid

* Making sure passwords are strong enough

* Verifying cell phone numbers

* Registering users

The rules for validation are:

* Username:

* Must have _

* Must not be, than 5 characters

* Password:

* Must be at least 8 characters

* Must have at least one uppercase letter

* Must have least one number

* Must have at least one special character

* Cell Phone:

* Must start with +27

* Must be followed by 9 digits

# 3. Login.java

This class handles:

* Checking if users are who they say they are

* Showing login status messages

# 4. Main.java

This class runs the program.

* Gets input from users

* Connects the registration and login processes

