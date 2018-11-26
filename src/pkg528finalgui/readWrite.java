package pkg528finalgui;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class readWrite {
	static String currentFile;
	public void createCustomer(String username, String password) {
		
	    BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(username+".txt"));
			writer.write(password);
			writer.newLine();
			writer.write("0");
		    writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	     
		
	}
	
	public Customer loadCustomer(String username, String password){
		//if(password.equals(getPass(username))){
			try {
				currentFile = username; 
				return new Customer(username, password, getBalance());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("ohs to the noes");
				e.printStackTrace();
			}
		//}
		return null;
	}

	public String getPass(String username) {
            try {
                BufferedReader read = new BufferedReader(new FileReader(username+".txt"));
               // read.close();
                return read.readLine();
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(readWrite.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) { 
                Logger.getLogger(readWrite.class.getName()).log(Level.SEVERE, null, ex);
            }
		return null;
	}

	public double getBalance() {
            try {
                BufferedReader read = new BufferedReader(new FileReader(currentFile+".txt"));
                read.readLine();
               // read.close();
                return Double.parseDouble(read.readLine());
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(readWrite.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) { 
                Logger.getLogger(readWrite.class.getName()).log(Level.SEVERE, null, ex);
            }
            return -1;
	}
	
	public void writeBalance(double balance){
		try {
			File file = new File(currentFile+".txt");
			List<String> lines;
			System.out.println("currentFile " + currentFile);
			lines = Files.readAllLines(file.toPath());
			lines.set(1, Double.toString(balance));
			Files.write(file.toPath(), lines);
                        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteCustomer(String username) {
		// TODO Auto-generated method stub
		File file = new File(username + ".txt");
		file.delete();
		
	}

}
