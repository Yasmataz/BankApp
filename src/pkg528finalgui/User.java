package pkg528finalgui;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public abstract class User {

	private String username;
	private String password;
	private boolean loggedIn;
	
	public User(String username, String password) throws IOException{
		this.username = username;
		this.password = password;
	}
	
	public void login(String username, String password){
		if(this.username.equals(username) && this.password.equals(password)){
			loggedIn = true;
		}
	}
	public void logOut(){
		loggedIn = false;
	}
        public String toString(){
            return("Username " + username + " password " + password);
        }
	
}
