# LoginSystem

# Overview 
This project is a login and registration system built using Java. I developed it using object-oriented programming principles. The system does the following:
Allows users to register an account
Checks their details like username, password and phone number
 Lets users log in using their stored credentials

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

# 3. Login.java
## This class handles:

* Checking if users are who they say they are

* Showing login status messages

# 4. Main.java
## This class runs the program.

* Gets input from users

* Connects the registration and login processes

## The rules for validation are:

* Username:

* Must have no more than 5 characters

* Password:

* Must be at least 8 characters

* Must have at least one uppercase letter

* Must have least one number

* Must have at least one special character

* Cell Phone:

* Must start with +27

* Must be followed by 9 digits

