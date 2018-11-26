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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yasamin
 */
public class CustomerController implements Initializable {
    private readWrite rw = new readWrite();
    private static Customer currentUser;
    private static Account account;
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
    @FXML
    private Label feeLbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        updateBalanceDisplay();
    }    

    public void initCust(String username, String password){
        currentUser = rw.loadCustomer(username, password);
        account = new Account(rw.getBalance());
        currentUser.loadAccount(account);
      //  updateBalanceDisplay();
        //System.out.println(currentUser.toString());
        
    }
    @FXML
    private void handleWithdraw(ActionEvent event) {
        currentUser.withdraw((Double.valueOf(amountTxt.getText())));
        rw.writeBalance(account.getBalance());
        updateBalanceDisplay();
        
    }

    @FXML
    private void handleDeposit(ActionEvent event) {
        currentUser.deposit((Double.valueOf(amountTxt.getText())));
        rw.writeBalance(account.getBalance());
        updateBalanceDisplay();
    }

    @FXML
    private void handleOrder(ActionEvent event) {
        if(Double.valueOf(orderTxt.getText())<=50){
            feeLbl.setText("Order must be at least $50");
            updateBalanceDisplay();
        }
        else{
            currentUser.withdraw(Double.valueOf(orderTxt.getText()) + account.calcFee());
            rw.writeBalance(account.getBalance());
            feeLbl.setText(Double.toString(account.calcFee()));
            updateBalanceDisplay();
        }
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.close();
    }

    private void updateBalanceDisplay() {
        balanceLbl.setText(" $" + Double.toString(rw.getBalance()));
    }
    
}
