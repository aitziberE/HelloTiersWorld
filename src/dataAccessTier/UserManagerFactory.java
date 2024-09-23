/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessTier;

import java.util.ResourceBundle;
/**
 *
 * @author Aitziber
 */
public class UserManagerFactory {
        private static final String DATA_SOURCE = ResourceBundle.getBundle("properties").getString("DATA_SOURCE");
        
    public static DataAccessible getDataAccessible() {
        switch (DATA_SOURCE) {
            case "db":
                return new DBUserDataAccessor();
            case "file":
                return new FileUserDataAccessor();
            default:
                // LOGGER
                throw new IllegalArgumentException("Invalid data source: " + DATA_SOURCE);
        }
    }
}
