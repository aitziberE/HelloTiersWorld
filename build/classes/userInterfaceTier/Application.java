/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterfaceTier;
import java.util.logging.Level;
import javafx.fxml.FXMLLoader;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Aitziber
 */
public class Application extends javafx.application.Application {
    
    /**
     * Logger instance used to log messages related to the application lifecycle, 
     * including startup, loading resources, and error handling.
     */
    private static final Logger LOGGER = Logger.getLogger(Application.class.getName());
    
    /**
     * The entry point for the JavaFX application. This method is called after the application is launched.
     * It is responsible for loading the FXML file and setting up the primary stage (window) with the loaded scene.
     * 
     * @param stage The primary stage for this application, onto which the application scene can be set.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage stage) throws Exception {
         try {
            // Log the start of the application
            LOGGER.log(Level.INFO, "Application started");

            // Load the FXML file for the UI
            Parent root = FXMLLoader.load(getClass().getResource("UserDataView.fxml"));
            LOGGER.log(Level.INFO, "FXML file 'UserDataView.fxml' loaded successfully");

            // Create a new scene using the loaded FXML layout
            Scene scene = new Scene(root);
            
            // Set the scene to the stage and display it
            stage.setScene(scene);
            stage.show();
            
            LOGGER.log(Level.INFO, "Primary stage displayed");
        } catch (Exception e) {
            // Log any exceptions that occur during startup
            LOGGER.log(Level.SEVERE, "Error occurred while starting the application", e);
        }
    }

    /**
     * Main method where the application is launched
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } 
}
