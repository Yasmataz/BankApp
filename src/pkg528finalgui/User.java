package pkg528finalgui;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


    public abstract class User {
        //Overview:This abstract class is responsible for storing the username,
        // password, and role of the useres (manager or customer)
        
        
	private String username;
	private String password;
	protected String role;
	
        //Effects: sets the password feild to the provided password
        //Modifies: password feild
        //Requires: a string (password) as input
	public void setPass(String pass) {
            this.password = pass;
        }

        //Effects: returns the user's password
        public String getPass() {
            return password;
        }

        //Efects: returns the user's role
        public String getRole() {
            return role;
        }
        
        //Effects: returns the user's username
        public String getUsername() {
            return username;
        }

        //Effects: sets the username feild to the provided username
        //Modifies: username feild
        //Requires: a string (username) as input
        public void setUsername(String username) {
            this.username = username;
        }

        public String toString(){
            return("Role: " + role + "Username: " + username + " Password: " + password);   
        }
	
        public boolean repOk(){
            if(username == null || password == null)
                return false;
            if(username.equals("") || password.equals(""))
                return false;
            return true;
            
        }
        
        public abstract void setRole();
}
