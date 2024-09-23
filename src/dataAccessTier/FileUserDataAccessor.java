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

/**
 *
 * @author Aitziber
 */
public class FileUserDataAccessor implements DataAccessible{
   private static final ResourceBundle USER_DATA = ResourceBundle.getBundle("config.userData");
    @Override
    public User getUserData() {
        User user= new User();
       
        user.setFirstName(USER_DATA.getString("firstName"));
        user.setLastName(USER_DATA.getString("lastName"));
        user.setUserName(USER_DATA.getString("userName"));
        user.setDni(USER_DATA.getString("dni"));
        user.setEmail(USER_DATA.getString("email"));

        String birthDateString = USER_DATA.getString("birthDate");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(birthDateString, formatter);
        user.setBithDate(birthDate);
        user.setPassword(USER_DATA.getString("password"));
        
        return user;
    }
}
