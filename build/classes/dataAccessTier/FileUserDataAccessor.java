/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessTier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import model.User;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * The {@code FileUserDataAccessor} class implements the {@code DataAccessible} interface to provide
 * access to user data stored in a properties file. It reads the user information from a properties
 * file and returns a {@code User} object containing this data.
 * 
 * The class utilizes the {@code ResourceBundle} class to read the user data from the
 * {@code config.userData} properties file. It also uses a {@code Logger} to log the process of
 * retrieving data, including successful data retrieval and any exceptions that occur.
 * 
 * The user data includes first name, last name, username, DNI, email, birth date, and password.
 * 
 * @see DataAccessible
 * @see User
 * 
 * @author Aitziber
 */
public class FileUserDataAccessor implements DataAccessible{
    
    /**
    * Fetches user data from the properties file and returns it as a {@code User} object.
    * 
    * This method reads user attributes such as first name, last name, username, DNI, email, birth
    * date, and password from the {@code config.userData} properties file. It parses the birth date
    * into a {@code LocalDate} object.
    * 
    * If any error occurs during data retrieval, it is logged and rethrown as an exception.
    * 
    * @return A {@code User} object populated with data from the properties file.
    */
    @Override
    public User getUserData() {
        
        ResourceBundle USER_DATA = ResourceBundle.getBundle("config.userData");
        
        Logger.getLogger("FileUserDataAccessor").info("Fetching user data from file");        
        User user= new User();
       
        user.setFirstName(USER_DATA.getString("firstName"));
        user.setLastName(USER_DATA.getString("lastName"));
        user.setUserName(USER_DATA.getString("userName"));
        user.setDni(USER_DATA.getString("dni"));
        user.setEmail(USER_DATA.getString("email"));

        String birthDateString = USER_DATA.getString("birthDate");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(birthDateString, formatter);
        user.setBirthDate(birthDate);
        user.setPassword(USER_DATA.getString("password"));
        
        Logger.getLogger("FileUserDataAccessor").log(Level.INFO, "User data successfully retrieved: {0}", user.toString());
        return user;
    }
}
