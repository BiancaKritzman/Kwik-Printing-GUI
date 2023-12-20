import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class EndUser {

	//These variables will store the name, email, password and type of the user
	private String UserName;
	private String UserEmail;
	private String UserPassword;
	private char type;
	
	//these are constants to identify if the user is a end user or reseller
	public final static char ENDUSER = 'e';
	public final static char RESELLER = 'r';
	
	//Constructor for each user object that takes in the user's name, email, password and type
	public EndUser(String Name, String Email, String Password, char t) {
		
		UserName = Name;
		UserEmail = Email;
		UserPassword = Password;
		type = t;
		
	}//end constructor 
	
	//GETTER METHODS 
	
	/** Accessor method to get the type of the user
	 * Non-static method 
	 * @return String type - returns the type of the user
	 * Takes in no parameters
	 */
	
	public String getType() {
		
		if(type == ENDUSER) {
			
			return "End User";
		}
		
		else {
			
			return "Reseller";
		}
	} //end method
	
	/** Accessor method to get the name of the user
	 * Non-static method
	 * @return String name - returns the name of the user
	 * Takes in no parameters
	 */
	
	public String getName() {
		return UserName;
	}//end method
	
	/** Accessor method to get the email address of the user
	 * Non-static method
	 * @return String email - returns the email address of the user
	 * Takes in no parameters
	 */
	
	public String getEmail() {
		return UserEmail;
	}//end method
	
	/** Accessor method to get the password of the user
	 * Non-static method
	 * @return String password - returns the password of the end user
	 * Takes in no parameters
	 */
	
	public String getPassword() {
		return UserPassword;
	}//end method
	
	/** Mutator method to set the type to be one for the current customer
	 * Void method
	 * @param char c -takes in the a character to represent the type of user as a parameter
	 */
	
	public void setType(char c) {
		
		type = c;
	}//end method
	
	/**This method saves the details the user entered, when signing up, to the "User.txt" text file
	 * Void method
	 * Takes in no parameters
	 */
	public void saveEndUser() {
		
		try {

			PrintWriter writer;
			writer = new PrintWriter(new FileWriter("User.txt", true)); //writing to the "User.txt" text file
	        writer.println(displayInfoInTxtFile());
	        
	        writer.close();
			
		} catch (IOException e) {
			
			System.out.println("IOException");
		}
		
	}//end method
	
	/**This method displays the users details in the format they will appear in the User.txt text file
	 * @return the format of the user object in the form of a String
	 */
	public String displayInfoInTxtFile() {
		
		return UserName + "#" + UserEmail + "#" + UserPassword + "#" + type;
		
	}
	//This method saves the users details in a string so that it can be displayed in the User.txt text file
	public String toString() {
		
		String temp = UserName + UserEmail + UserPassword;
		
		return temp;
	}//end method
	
	/**This method returns a boolean which test if 2 endUser object are equal 
	 * 
	 *@return true if all the fields equal the ones in the "User.txt" text file & returns false if
	 *the fields for the user are not found
	 */
	public boolean equal(EndUser e) {
		
		return e.UserEmail.equals(this.UserEmail) && e.UserName.equals(this.UserName) && e.UserPassword.equals(this.UserPassword);
	}//end method
	
	}//end class

    
