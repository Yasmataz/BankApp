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
public class BankGUIController implements Initializable {

    @FXML
    private Button loginBtn;
    @FXML
    private TextField usernameTxt;
    @FXML
    private TextField passwordTxt;

   User currentUser;
    @FXML
    private CheckBox checkbox;
    public void loadProfile(String username, String password){
		try {
			currentUser = new Customer(username, password, 0);
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
        AccountController ac = new AccountController();
        ac.initCust(usernameTxt.getText(), passwordTxt.getText());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("Account");
        stage.setScene(new Scene(root, 600, 400));
        stage.showAndWait();
        
    }

    @FXML
    private void handleCheck(ActionEvent event) {
    }

    
}
