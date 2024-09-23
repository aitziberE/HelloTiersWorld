/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterfaceTier;

import dataAccessTier.UserManagerFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.User;

/**
 *
 * @author Aitziber
 */
public class UserDataWindowController implements Initializable {
    
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
               //label.setDisable(true);
           }   
        }
        catch (Exception e){
            // LOGGER e
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label.setText("Click to get user data");
    }    
}
