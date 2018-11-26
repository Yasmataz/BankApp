package pkg528finalgui;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Manager extends User{
    readWrite rw = new readWrite();
    public Manager() {
        super.setPass("admin");
        super.setUsername("admin");
        setRole();
    }

    @Override
    public void setRole() {
        super.role="Manager";
    }

	
    public void addCustomer(String username, String password) throws IOException{
		    
	rw.createCustomer(username, password);
		
    }
	
	public void deleteCustomer(String username){
    	rw.deleteCustomer(username);
    }
}
