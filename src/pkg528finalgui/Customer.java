package pkg528finalgui;
import java.io.IOException;


public class Customer extends User{
	
	private Account account;
	
        public Customer(String username, String password) throws IOException{
		super.setPass(password);
                setRole();
                super.setUsername(username);
	}

	void loadAccount(Account account) {
            this.account = account; 
        }
        public void deposit(double amount) {
		account.deposit(amount);
	}
	public void withdraw(double amount){
		account.withdraw(amount);
	}
        public void setRole() {
                super.role = "Customer";
        }
        public String toString(){
            return(super.toString());
        }
}
