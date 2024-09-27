/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterfaceTier;

import dataAccessTier.UserManagerFactory;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.User;

/**
 *
 * @author Aitziber
 */
public class UserDataWindowController {
    
    /**
    * Label in the UI used to display user data or messages.
    * It is annotated with {@code @FXML} to indicate that it is injected from the FXML file.
    */
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try{
           User user = UserManagerFactory.getDataAccessible().getUserData();
           if (user == null){
               label.setText("user not found");
           } else {
               label.setText(user.toString());
           }   
        }
        catch (Exception e){
            Logger.getLogger("UserDataWindowController").severe(e.getLocalizedMessage());
            new Alert(Alert.AlertType.ERROR, e.getLocalizedMessage(), ButtonType.OK).showAndWait();
        }
    }
}
