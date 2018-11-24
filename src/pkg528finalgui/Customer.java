package pkg528finalgui;
import java.io.IOException;


public class Customer extends User{
	
	private Account account;
	private readWrite rw = new readWrite();
	public Customer(String username, String password, double balance) throws IOException{
		super(username, password);
		account = new Account(rw.getBalance());
	}

	public void deposit(double amount) {
		account.deposit(amount);
	}
	public void withdraw(double amount){
		account.withdraw(amount);
	}
        
        public String toString(){
            return(super.toString());
        }

	
}
