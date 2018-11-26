package pkg528finalgui;
public class Account {
	
	State myState;
	private double balance;
	
	public Account(double balance){
		this.balance = balance;
		checkState();
	}
	
	public State getState(){
		return myState;
		
	}
	public void setState(State state){
		this.myState = state;
	}
	
	public double calcFee(){
		return myState.calcFee();
		
	}
	public boolean makePurchase(double amount){
		if(amount >= 50){
			withdraw(amount + myState.calcFee());
			return true;
		}
		return false;
	}
	public void deposit(double amount){
		balance += amount;
		checkState();
	}
	
	public void withdraw(double amount){
		balance -= amount;
		checkState();
	}
	
	public double getBalance(){
		return balance;
	}
	
	private void checkState() {
		if(balance < 1000)
			myState = new Silver();
		else if(balance >= 1000 && balance < 2000)
			myState = new Gold();
		else
			myState = new Platinum();
		
	}
	@Override
	public String toString(){
		return("Balance: " + balance);
	}
	
	
}
