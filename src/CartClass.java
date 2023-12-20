import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Scanner;

public class CartClass {

	//these variables will store the type, quantity, number of orders and price of the customer's order
	private String OrderType;
	private String OrderQuantity;
	private int NumberOfOrders;
	private double OrderPrice;
	
	//Constructor for each cart object that takes in the type, quantity and the number of orders 
	public CartClass(String type, String quantity, int numOrders) {
		
		OrderType = type;
		OrderQuantity = quantity;
		NumberOfOrders = numOrders;
		    	
		    	if(OrderQuantity.equals("250")) {
		    	
		    	 OrderPrice = 100.00;
		    	 
		    	}
		    	
		    	else if(OrderQuantity.equals("500")) {
		    		
		    	 OrderPrice = 200.00;
		       	 
		    	}
		    	
		    	else if(OrderQuantity.equals("1000")) {
		    		
		       	 OrderPrice = 500.00;
		 
		       	}
		    	
		    	else if(OrderQuantity.equals("5000")) {
		    		
		       	 OrderPrice = 2500.00;
		          	 
		       	}
		    	
		    	else if(OrderQuantity.equals("10000")) {
		    		
		       	 OrderPrice = 4000.00;
		          	 
		       	}
		    }//end of constructor
	
	//Constructor for each cart object that takes in the type, quantity, number of orders and price
	public CartClass(String type, String quantity, int numOrders, double price) {
		
		OrderType = type;
		OrderQuantity = quantity;
		NumberOfOrders = numOrders;
		OrderPrice = price;
	}//end of constructor
	
	//Constructor for each cart object that is a special order. It takes in a special variable and the number of orders
	public CartClass(int special, int numOrders) {
		
		if(special == 1) {
			
			OrderType = "Business Cards";
			OrderQuantity = "500";
			NumberOfOrders = numOrders;
			OrderPrice = 300.00*numOrders;
			//all the details of every special order
		}
		
		else if (special == 2) {
			
			OrderType = "Flyers";
			OrderQuantity = "1000";
			NumberOfOrders = numOrders;
			OrderPrice = 820.00*numOrders;
			//all the details of every special order

		}
		
		else if(special == 3) {
			
			OrderType = "Posters";
			OrderQuantity = "50";
			NumberOfOrders = numOrders;
			OrderPrice = 2260.00*numOrders;
			//all the details of every special order

		}
		
		else if (special == 4) {
			
			OrderType = "Posters";
			OrderQuantity = "100";
			NumberOfOrders = numOrders;
			OrderPrice = 1860.00*numOrders;
			//all the details of every special order

		}
		
		else if(special == 5) {
			
			OrderType = "Folders";
			OrderQuantity = "500";
			NumberOfOrders = numOrders;
			OrderPrice = 5040.00*numOrders;
			//all the details of every special order
			
		}
		
	}//end of constructor 
	
	/**This method adds an extra R100 if the customer selects the checkbox for rounded corners
	 * Void method
	 * Non-static method
	 * Takes in no parameters
	 */
	
	public void addRoundedCorners() { //only for special 1
		
		OrderPrice += 100.00*NumberOfOrders;
	}//end method
	
	//GETTER METHODS
	
	/**Accessor method to get the type of the order the customer has choosen
	 * Non-static method
	 * @return String type - returns the type the customer has selected in their order
	 * Takes in no parameters
	 */
	public String getType() {
		return OrderType;
	}//end method
	
	/**Accessor method to get the quantity of the order the customer has choosen
	 * Non-static method
	 * @return String quantity - returns the quantity the customer has selected in their order
	 * Takes in no parameters
	 */
	
	public String getQuantity() {
		return OrderQuantity;
	}//end method
	
	/**Accessor method to get the number of orders from the order the customer has choosen
	 * Non-static method
	 * @return int numberOfOrders - returns the number of orders the customer has selected of their order
	 * Takes in no parameters
	 */
	
	public int getNumberOfOrders() {
		return NumberOfOrders;
	}//end method
	
	/**Accessor method to get the price of the order the customer has choosen
	 * Non-static method
	 * @return double price - returns the price the customer has selected in their order
	 * Takes in no parameters
	 */
	public double getPrice() {
		return OrderPrice;
	}//end method

	
	public String toString() {
		
		String temp = "";
		
		temp = OrderType + OrderQuantity + NumberOfOrders+ OrderPrice;  
				
		return temp;
	}
		
	/**This method saves the details the customer has selected, from either their custom order or the special order, to the "Cart.txt" text file
	 * Void method
	 * Non-static method
	 * Takes in no parameters
	 */
	
	public void saveOrder() {
		
		try {
			PrintWriter writer;
			writer = new PrintWriter(new FileWriter("Cart.txt", true)); //writing to the "Cart.txt" text file
	        writer.println(displayInfoInTxtFile());
	        
	        writer.close();
			
		} catch (IOException e) {
			
			System.out.println("File can't be found");
		}
		
	}//end method
	
	/**This method displays the users details in the format they will appear in the "Cart.txt" text file
	 * Non-static method
	 * @return the format of the user object in the form of a String
	 */

	public String displayInfoInTxtFile() {
		
		return OrderType + "#" + OrderQuantity + "#" + NumberOfOrders + "#" + OrderPrice;
		
	}//end method
	
}//end class
