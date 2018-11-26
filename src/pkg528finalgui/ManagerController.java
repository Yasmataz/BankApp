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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yasamin
 */
public class ManagerController implements Initializable {

    @FXML
    private Button deleteBtn;
    @FXML
    private Button addBtn;
    @FXML
    private Button logoutBtn;

    Manager manager = new Manager();
    @FXML
    private TextField passwordTxt;
    @FXML
    private TextField username1Txt;
    @FXML
    private TextField username2Txt;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleLogout(ActionEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleDelete(ActionEvent event) {
        manager.deleteCustomer(username2Txt.getText());
        username2Txt.clear();
    }

    @FXML
    private void handleAdd(ActionEvent event) throws IOException {
        manager.addCustomer(username1Txt.getText(), passwordTxt.getText());
        username1Txt.clear();
        passwordTxt.clear();
    }
    
}
