/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessTier;

import model.User;

/**
 * The {@code DataAccessible} interface defines a contract for accessing user data.
 * 
 * Any class that implements this interface must provide an implementation for
 * retrieving a {@link User} object that contains user-specific information.
 * 
 * This interface is designed to allow flexibility in how user data is accessed, 
 * whether from a database, a file system, or any other source. Implementing classes 
 * are responsible for the specific details of how data is fetched and provided.
 * 
 * @author Aitziber
 */
public interface DataAccessible {
    
    /**
    * Retrieves the user data and returns it as a {@link User} object.
    * 
    * Implementing classes should handle the logic for fetching user data 
    * from the appropriate source (e.g., a database or a file).
    * 
    * If there is any issue during data retrieval, this method may throw 
    * an exception.
    * 
    * @return A {@link User} object containing the user's data.
    * @throws Exception If an error occurs during the data retrieval process.
    */
    public User getUserData() throws Exception;
}
