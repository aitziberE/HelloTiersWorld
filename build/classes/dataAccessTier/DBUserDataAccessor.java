/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessTier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
* The {@code DBUserDataAccessor} class implements the {@code DataAccessible} interface 
* to provide access to user data stored in a database.
* 
* This class connects to a MySQL database to fetch user information such as first name, 
* last name, username, DNI, email, birth date, and password. It also manages opening 
* and closing of database connections and logs all important actions and exceptions.
* 
* The database connection details (e.g., URL, username, password) are hardcoded, 
* and the SQL query used to fetch the user data is predefined.
* 
* @see DataAccessible
* @author Aitziber
*/
public class DBUserDataAccessor implements DataAccessible{
    
    /**
     * Logger instance used to log events related to database connections 
     * and data retrieval, as well as any exceptions.
     */
    private static final Logger LOGGER = Logger.getLogger(DBUserDataAccessor.class.getName());
    
    /**
    * SQL query to retrieve user data from the database.
    */
    private static final String GET_USER_DATA = "SELECT * FROM user";
    
    /**
    * Opens a connection to the MySQL database.
    * 
    * This method connects to the database using the specified URL, username, and password.
    * If the connection is successful, it logs a message. Otherwise, it logs an error message.
    * 
    * @return A {@code Connection} object to interact with the database, or {@code null} if the connection fails.
    */
    public Connection openConnection() {
        Connection con = null;
        try {
            LOGGER.log(Level.INFO, "Opening connection to the database...");
            String url = "jdbc:mysql://localhost:3306/hellotiersdb?serverTimezone=Europe/Madrid&useSSL=false";
            con = DriverManager.getConnection(url, "root", "abcd*1234");
        LOGGER.log(Level.INFO, "Connection to database established successfully.");
        } catch (SQLException e) {
            // LOGGER: System.out.println("Error al intentar abrir la BD");
        }
        return con;
    }
    
    /**
    * Closes the given database connection and statement.
    * 
    * This method ensures that both the {@code PreparedStatement} and {@code Connection} 
    * are closed properly. It logs the success or failure of the closing operations.
    * 
    * @param stmt The {@code PreparedStatement} to be closed.
    * @param con The {@code Connection} to be closed.
    */
     public void closeConnection(PreparedStatement stmt, Connection con) throws SQLException {
        // LOGGER System.out.println("Conexion cerrada");
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
        LOGGER.log(Level.INFO, "Connection closed successfully.");
    }
    
    /**
    * Retrieves user data from the database and returns it as a {@code User} object.
    * 
    * This method executes an SQL query to fetch user data, including first name, last name, 
    * username, DNI, email, birth date, and password. The data is then populated into a 
    * {@code User} object. If any errors occur during the retrieval process, they are logged.
    * 
    * @return A {@code User} object containing the user's data, or {@code null} if no user data is found.
     * @throws java.sql.SQLException
    */
    @Override
    public User getUserData() throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        User user = null;

        try {
            con = openConnection();
            stmt = con.prepareStatement(GET_USER_DATA);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                                
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setUserName(rs.getString("userName"));
                user.setDni(rs.getString("dni"));
                user.setEmail(rs.getString("email"));
                java.sql.Date sqlDate = rs.getDate("birthDate");
                
                if (sqlDate != null) {
                    user.setBirthDate(sqlDate.toLocalDate());
                }
                
                user.setPassword(rs.getString("password"));
                LOGGER.log(Level.INFO, "User data successfully retrieved: {0}", user.toString());
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error fetching user data: {0}", e.getMessage());
        } finally {
            try {
                closeConnection(stmt, con);
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Error while closing the connection: {0}", e.getMessage());
                throw e;
            }
        }
        return user;
    }
    
}
