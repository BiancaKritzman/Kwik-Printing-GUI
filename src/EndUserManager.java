import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EndUserManager {

	private EndUser[] arrEndUser = new EndUser[100]; //this array will store all the user objects when populated
	private int noEndUser = 0; //this variable stores the number of users that have accounts
	
	/** This constructor populates the arrEndUser array with all user objects stored in the "User.txt" text file
	 * Takes in no parameters
	 */
	public EndUserManager() {
		
		try {
			Scanner sc = new Scanner( new File ("User.txt"));//tells the Scanner to scan information from the "User.txt" text file
			
			while(sc.hasNext()) { //scan each line of the "User.txt" text file until there are no more lines
				
				String line = sc.nextLine(); //reading each line
				
				Scanner scLine = new Scanner(line).useDelimiter("#");
				
				//separating variables for object
				String name = scLine.next();
				String email = scLine.next();
				String password = scLine.next();
				char t = scLine.next().charAt(0);
				
				//creating a new User object with the variables from the text file as the parameters
				EndUser e = new EndUser(name, email, password, t);
				arrEndUser[noEndUser] = e; //add the newly created User object to the array arrEndUser
				noEndUser++; //increasing noEndUser by one to reflect the number of objects now in the array
				
				scLine.close();
			}//end while loop
			sc.close();
		}
		
		catch(FileNotFoundException e){
			
			System.out.println("File not found");
		}
	}//end constructor 
	
			/**method that checks if the user that is logging in exists 
			 * Non-static method
			 * @param name - it takes in the user's name as parameters
			 * @param email - it takes in the user's email address as parameters
			 * @param password - it takes in the user's password as parameters
			 * @return true if user found, else it will return false if the user is not found
			 */
			public boolean userExists(String name, String email, String password) {
				
				for(int i = 0; i<noEndUser; i++) {
					
					if(arrEndUser[i].getName().equals(name) && arrEndUser[i].getEmail().equalsIgnoreCase(email) && arrEndUser[i].getPassword().equalsIgnoreCase(password)) {
						
						return true;
					}
			
				}//end for loop
				
				return false;
			}//end userExists

	}//end class

