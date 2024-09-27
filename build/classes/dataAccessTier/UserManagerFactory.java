/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessTier;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* The {@code UserManagerFactory} class is responsible for providing an appropriate data access
* implementation based on a configuration value. The data source is determined from a properties 
* file, and this class returns either a database accessor or a file-based accessor accordingly.
* 
* This class uses the {@code ResourceBundle} to load configuration values and a {@code Logger}
* to log important events, such as which data source is being used or if an error occurs while 
* selecting the data source.
* 
* The configuration is retrieved from the {@code config.properties} file, and the 
* {@code DATA_SOURCE} property determines whether the application should use a database or file 
* system for data access.
* 
* @author Aitziber
* @see DBUserDataAccessor
* @see FileUserDataAccessor
*/
public class UserManagerFactory {
    
    /**
    * The data source identifier, which is loaded from the {@code config.properties} file.
    * This value determines whether to use a database or file system for accessing user data.
    */
    private static final String DATA_SOURCE = ResourceBundle.getBundle("config.properties").getString("DATA_SOURCE");
        
    public static DataAccessible getDataAccessible() {
        switch (DATA_SOURCE) {
            case "db":
                Logger.getLogger("UserManagerFactory").info("Using database as data source");
                return new DBUserDataAccessor();
            case "file":
                Logger.getLogger("UserManagerFactory").info("Using file system as data source");
                return new FileUserDataAccessor();
            default:
                Logger.getLogger("UserManagerFactory").log(Level.SEVERE, "Invalid data source:{0}", DATA_SOURCE);
                throw new IllegalArgumentException("Invalid data source: " + DATA_SOURCE);
        }
    }
}
