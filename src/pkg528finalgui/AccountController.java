    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg528finalgui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Yasamin
 */
public class AccountController implements Initializable {
    readWrite rw = new readWrite();
    static Customer currentUser;
    @FXML
    private TextField amountTxt;
    @FXML
    private TextField orderTxt;
    @FXML
    private Button withdrawBtn;
    @FXML
    private Button depositBtn;
    @FXML
    private Button orderBtn;
    @FXML
    private Button logoutBtn;
    @FXML
    private Label balanceLbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void initCust(String username, String password){
        System.out.println("pkg528finalgui.AccountController.initCust()");
        currentUser = rw.loadCustomer(username, password);
        System.out.println(currentUser.toString());
       // updateBalanceDisplay();
        
    }
    @FXML
    private void handleWithdraw(ActionEvent event) {
        currentUser.withdraw((Double.valueOf(amountTxt.getText())));
        updateBalanceDisplay();
    }

    @FXML
    private void handleDeposit(ActionEvent event) {
        currentUser.deposit((Double.valueOf(amountTxt.getText())));
        updateBalanceDisplay();
    }

    @FXML
    private void handleOrder(ActionEvent event) {
    }

    @FXML
    private void handleLogout(ActionEvent event) {
    }

    private void updateBalanceDisplay() {
        balanceLbl.setText(Double.toString(rw.getBalance()));
    }
    
}
