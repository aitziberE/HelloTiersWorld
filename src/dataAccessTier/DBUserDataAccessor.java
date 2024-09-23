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
import model.User;

/**
 *
 * @author Aitziber
 */
public class DBUserDataAccessor implements DataAccessible{
    private static final String GET_USER_DATA = "SELECT * FROM user";
    
    public Connection openConnection() {
        // TODO Auto-generated method stub
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/hellotiersdb?serverTimezone=Europe/Madrid&useSSL=false";
            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            // LOGGER: System.out.println("Error al intentar abrir la BD");
        }
        return con;
    }
    
     public void closeConnection(PreparedStatement stmt, Connection con) throws SQLException {
        // LOGGER System.out.println("Conexion cerrada");
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
    }
    
    
    @Override
    public User getUserData() {
        Connection con = null;
        PreparedStatement stmt = null;
        User user = null;

        try {
            con = openConnection();
            stmt = con.prepareStatement(GET_USER_DATA);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                
                // validar que el campo no sea null
                
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setUserName(rs.getString("userName"));
                user.setDni(rs.getString("dni"));
                user.setEmail(rs.getString("email"));
                java.sql.Date sqlDate = rs.getDate("birthDate");
                
                // refactorizar
                if (sqlDate != null) {
                    user.setBithDate(sqlDate.toLocalDate());
                }
                
                user.setPassword(rs.getString("password"));
            }

        } catch (SQLException e) {
            // LOGGER System.out.println("Error al obtener los datos del usuario: " + e.getMessage());
        } finally {
            try {
                closeConnection(stmt, con);
            } catch (SQLException e) {
                // LOGGER System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return user;
    }
    
}
