/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg528finalgui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yasamin
 */
public class LoginController implements Initializable {

    @FXML
    private Button loginBtn;
    @FXML
    private TextField usernameTxt;
    @FXML
    private TextField passwordTxt;

    private User currentUser;
    private readWrite rw = new readWrite();
    public void loadProfile(String username, String password){
		try {
			currentUser = new Customer(username, password);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleLoginBtn(ActionEvent event) throws IOException {
        String username = usernameTxt.getText();
        String password = passwordTxt.getText();
        
        if(username.equals("admin") && authenticate(username, password)){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("manager.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOpacity(1);
            stage.setTitle("Manager");
            stage.setScene(new Scene(root, 600, 400));
            stage.showAndWait();
        }
        else{
            CustomerController ac = new CustomerController();
            ac.initCust(username, password);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("customer.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOpacity(1);
            stage.setTitle("Account");
            stage.setScene(new Scene(root, 600, 400));
            stage.showAndWait();
        }
    }

    private boolean authenticate(String username, String password) {
        if(rw.getPass(username).equals(password))
            return true;
        return false;
    }

}
