package pkg528finalgui;
import java.io.IOException;
import java.util.Stack;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main_1  {
	Customer currentCustomer;
	
	public void loadProfile(String username, String password){
		try {
			currentCustomer = new Customer(username, password, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String args[]) throws IOException{
		//launch(args); 
		
		readWrite rw = new readWrite();
		Manager fred = new Manager("Fred", "Payne");
		
		fred.addCustomer("billy", "woolford");
		
		Customer billy = rw.loadCustomer("billy", "woolford");
		billy.deposit(1000.0);
	//	System.out.println(billy.toString());
		
		fred.addCustomer("Mai", "Hameed");
		
		//fred.deleteCustomer("Mai");
		
	}
}
