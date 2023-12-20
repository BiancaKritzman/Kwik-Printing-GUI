import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class CartManager {

	private CartClass[] arrCart = new CartClass[100]; //stores all CartClass objects (all the orders)
	private int noCart = 0; //stores the number of orders in the array arrCart
	
    /**This constructor populates the arrCart array with data from the "Cart.txt" text file (CartClass objects)
	 * Takes in no parameters
	 */
	public CartManager(){
		//scannering the cart text file to put the information in the table on the cart page
		try {
			Scanner sc = new Scanner(new File("Cart.txt"));
			
			while(sc.hasNext()) {
				
				String cart = sc.nextLine(); //reading each line
				
				Scanner scCart = new Scanner(cart).useDelimiter("#");
				
				//separting into variables for the object
				String type = scCart.next();
				String quantity = scCart.next();
				int numOrders = scCart.nextInt();
				double price = Double.parseDouble(scCart.next());
				
				CartClass c = new CartClass(type, quantity, numOrders, price); //creating a new CartClass object
				arrCart[noCart] = c; //adding the object to the array
				noCart++; //increasing noCart by one to reflect the number of objects now in the array
				
				scCart.close();
			}sc.close();//end while loop 
		} catch (FileNotFoundException e) {

			System.out.println("File not Found");
		}	
	}//end constructor
	
	/**method that checks if a order exists and then if it does it will be deleted
	 * Non-static method
	 * @param String order - it takes in the order the code is looking for as parameters
	 * @return String delete the order it was looking for if it found it or returns that the order was
	 * not found
	 * Takes in no parameters
	 */
	public String delete(String order) { //method that deletes orders
		
		 // Find the index of the order to delete
	    int index = -1;
	    for (int i = 0; i < noCart; i++) {
	        if (arrCart[i].equals(order)) {
	            index = i;
	            break;
	        }
	    }
	  
	    // If the order exists in the array, remove it
	    if (index != -1) {
	        CartClass[] newArrCart = new CartClass[noCart - 1];
	        for (int i = 0, j = 0; i < noCart; i++) {
	            if (i != index) {
	                newArrCart[j++] = arrCart[i];
	            }
	        }
	        arrCart = newArrCart;
	        return "Order '" + order + "' deleted successfully.";
	        
	    } else {
	        return "Order not found.";
	    }	
}
	
	/**method that deletes the order that the customer has selected
	 * void method
	 * @param int indexOrder - it takes in the index of the order that is going to be deleted as parameters
	 * Takes in no parameters
	 */
	public void shiftLess(int indexOrder) {
		
		for(int i = indexOrder; i < noCart -1; i++) {
			
			arrCart[i] = arrCart[i+1];
		}
		//noCart-- so that the variable that stores the size of the array reflects that a index has been deleted
		noCart--;
		Arrays.toString(arrCart);
		UpdateTextFile();
		
	}//end method
	
	/**This method that will take the updated array and write it back to the text file
	 * void method
	 * Takes in no parameters
	 */
	public void UpdateTextFile() {
		
		try {
		PrintWriter writer;
		writer = new PrintWriter(new FileWriter("Cart.txt", false)); //false so can clear content
		
		for(int i = 0; i < noCart; i++) {
				
		        writer.println(arrCart[i].displayInfoInTxtFile());
				
			}
		 writer.close();
		}
		catch (IOException e) {
				
				System.out.println("IOException");
			}
			
		}//end method
	
    /**This method is used to populate the JTable, double array, on the Cart Page
     * Non-static method
     * @return String[][]info - returns a double array for the JTable 
     * Takes in no parameters
     */
    public String[][] salesDataforTable() {
    	
    	String[][] info = new String[noCart][4];
		
		for(int i = 0; i<noCart; i++) {
			info[i][0] = arrCart[i].getType(); //the first column of the JTable is for the type of the customer's order
			
		}//end for loop
		
		for(int i = 0; i<noCart; i++) {
				
				info[i][1] = arrCart[i].getQuantity(); //the second column of the JTable is for the quantity of the customer's order
					
		}//end for loop
		
		for(int i = 0; i<noCart; i++) {
				
				info[i][2] = "" + arrCart[i].getNumberOfOrders(); //the third column of the JTable is for the number of orders of the customer's order
				
		}//end for loop
		
		for(int i = 0; i<noCart; i++) {
			
			info[i][3] = "" + arrCart[i].getPrice(); //the fourth column of the JTable is for the price of the customer's order
			
	}//end for loop

			return info; 
    }//end method
    
    /** This method calculates the total price of all the customer's orders
     * Non-static method
     * @return double calcPrice - returns the total price of all the orders that have been added to the
     * JTable, double array
     * Takes in no parameters
     */
    public double calcTotalPrice() {
      	
      double total = 0;
		
		for(int i = 0; i<noCart; i++) {
			total += arrCart[i].getPrice();
		}//end for loop
		return total;
    }//end method
    
    
    /**Accessor method to get the number of orders in the arrCart
     * Non-static method
     * @return int getNoCart - returns the noCart 
     * Takes in no parameters
     */
    public int getNoCart() {
    	return noCart;
    }//end method 
    
    /**This method deletes all the orders in the array and Jtable once the customer has purchased them
     * Void method
     * Takes in no parameters
     */
    public void ClearArray() {
    	
    	int temp = noCart;
    	for (int i = 0; i < temp; i++) {
    		
    		shiftLess(0); //using the shiftLess method above that deletes 1 object in the array
    		

    	}//end for loop
    	
    	
    }//end method
    
   }//end class
