/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 * The {@code User} class represents a user in the system.
 * It contains user-related attributes such as first name, last name, username, 
 * DNI, email, birth date, and password.
 * 
 * This class provides getter and setter methods for each attribute, 
 * as well as a {@code toString} method for displaying user information.
 * 
 * Additionally, the class offers two constructors: a no-argument constructor
 * and a parameterized constructor for creating user objects with initial values.
 * 
 * @author Aitziber
 */
public class User {
    
    /**
    * @param firstName The first name of the user.
    * @param lastName The last name of the user.
    * @param userName The username of the user.
    * @param dni The DNI of the user.
    * @param email The email address of the user.
    * @param birthDate The birth date of the user.
    * @param password The password of the user.
    */
    private Integer id;
    private String firstName;
    private String lastName;
    private String userName;
    private String dni;
    private String email;
    private LocalDate birthDate;
    private String password;
    
    /**
     * Default no-argument constructor for creating a new {@code User} object.
     */
    public User(){
        
    }
    
    /**
    * Parameterized constructor for creating a {@code User} object with initial values.
    */
    public User (String firstName, String lastName, String userName, String dni, String email, LocalDate birthDate, String password){
        
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=userName;
        this.dni=dni;
        this.email=email;
        this.birthDate=birthDate;
        this.password=password;
    }
    
    /**
    * Gets the user's unique identifier.
    * 
    * @return The user's ID.
    */
    public Integer getId() {
        return id;
    }

    /**
    * Gets the user's first name.
    * 
    * @return The user's first name.
    */
    public String getFirstName() {
        return firstName;
    }
    
    /**
    * Sets the user's first name.
    * 
    * @param firstName The new first name for the user.
    */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
    * Gets the user's last name.
    * 
    * @return The user's last name.
    */
    public String getLastName() {
        return lastName;
    }
    
    /**
    * Sets the user's last name.
    * 
    * @param lastName The new last name for the user.
    */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
    * Gets the user's username.
    * 
    * @return The user's username.
    */
    public String getUserName() {
        return userName;
    }
    /**
    * Sets the user's username.
    * 
    * @param userName The new username for the user.
    */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
    * Gets the user's DNI.
    * 
    * @return The user's DNI.
    */
    public String getDni() {
        return dni;
    }
    
    /**
    * Sets the user's DNI.
    * 
    * @param dni The new DNI for the user.
    */
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    /**
    * Gets the user's email address.
    * 
    * @return The user's email address.
    */
    public String getEmail() {
        return email;
    }
    
    /**
    * Sets the user's email address.
    * 
    * @param email The new email address for the user.
    */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
    * Gets the user's birth date.
    * 
    * @return The user's birth date.
    */
    public LocalDate getBithDate() {
        return birthDate;
    }
    
    /**
    * Sets the user's birth date.
    * 
    * @param birthDate The new birth date for the user.
    */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    
    /**
    * Gets the user's password.
    * 
    * @return The user's password.
    */
    public String getPassword() {
        return password;
    }
    
    /**
    * Sets the user's password.
    * 
    * @param password The new password for the user.
    */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
    * Returns a string representation of the {@code User} object, containing the user's first name, last name, username, DNI, email, and birth date.
    * 
    * @return A string representation of the user.
    */
    @Override
    public String toString() {
         return "User{\n" +
            "firstName=" + firstName + "\n" + 
            "lastName=" + lastName + "\n" +
            "userName=" + userName + "\n" +
            "dni=" + dni + "\n" +
            "email=" + email + "\n" +
            "birthDate=" + birthDate + "\n" +
            '}';
    }
}
