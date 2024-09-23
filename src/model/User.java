/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Aitziber
 */
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String userName;
    private String dni;
    private String email;
    private LocalDate bithDate;
    private String password;
    
    public User(){
        
    }
    
    public User (String firstName, String lastName, String userName, String dni, String email, LocalDate bithDate, String password){
        
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=userName;
        this.dni=dni;
        this.email=email;
        this.bithDate=bithDate;
        this.password=password;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBithDate() {
        return bithDate;
    }

    public void setBithDate(LocalDate bithDate) {
        this.bithDate = bithDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", dni=" + dni + ", email=" + email + ", bithDate=" + bithDate + '}';
    }
}
