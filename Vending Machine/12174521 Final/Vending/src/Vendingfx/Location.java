package Vendingfx;

import java.io.FileNotFoundException;
/* aclass that represents a location in vending machine
 * Each location can only have a maximum on 10 products
 * the products in the location have to have same name and price 
 */

public class Location {
//location has a position, count of product and a product
	private String position;
	private int productsCount;
	private Product product;

	public Location(String position) {
		
		this.position = position;//initialise with the location id
			
	}
	
///////////////////////////////////////////////////////////////////////////////////////
	// a method to reset a product in a location to null, so a new type of prod
	//used in VM class remove method.
	//can be used if the product quantity becomes 0
	public void resetProduct() {
		this.product = null;
	}
///////////////////////////////////////////////////////////////////////////////////////
	/*a method to add a product to the location
	 * @return a message for admin about success of loading product
	 */
	
	public String addProduct(Product product) {
		String addMessage = "Welcome";//default to welcome
		if (this.product == null && product.getQuantity()<11) {//check that location is free  and check that quantity is less than 10
			addMessage = "You product has been loaded";
			this.product = product;
			this.productsCount = this.product.getQuantity();//make the quantity the count of products it that location incase of top-up
		}
		else if(this.product == null && product.getQuantity()>10) {//if location is free but they try to add more than 10
			addMessage = "Only 10 products allowed";
		}
		
		
		else if ((this.product.getDescription().equalsIgnoreCase(product.getDescription()))//if the space has a product check it is same as product to be 'topped-up'
				&& ((this.product.getPrice()== product.getPrice()))&& (10 - this.product.getQuantity() >= product.getQuantity()) && (10 - productsCount >= product.getQuantity()))
		{//check same price and name and that there is space i the location (i.e. max of 10 product count)
			addMessage = "You product has been loaded ";
			this.productsCount += product.getQuantity(); //add the new quantity to product count
			
		}
		else if(!this.product.equals(product) && getProductsCount()==0) {// add the product if there is an empty space
			addMessage = "Your product has been loaded";
			this.product = product;
			this.productsCount = product.getQuantity();
			} 
		else{
			addMessage = "Choose a different location";//if there is no space for the new product or there is a diff prod in that location
			product = null;
		}
		return addMessage;
		}
///////////////////////////////////////////////////////////////////////////////////////

	
/////////////////////////////////////////////////////////////////////////////////////
	/*a method that sets the positon id of a location
	 * @ param String position id
	 */
	public void setPosition(String position) {
		this.position = position;
	}
/////////////////////////////////////////////////////////////////////////////////////
	/*a method that get the position of a location
	 * @ return String position
	 */
	public String getPosition() {
		return this.position;
	}

//////////////////////////////////////////////////////////////////////////////////////
/*a method that gets the count of the products in a location
 * @ return int product count
 */
	public int getProductsCount() {
		int count = 0;
		if (this.product == null) {//check for null so no pointers thrown

		} else {
			count = this.productsCount;
		}
		return count;
	}

//////////////////////////////////////////////////////////////////////////////////////
	/* a method to return the product at the location
	 * @ return product
	 */
	
	
	public Product getProduct() {
		return this.product;
	}

///////////////////////////////////////////////////////////////////////////////////////	

///////////////////////////////////////////////////////////////////////////////////////
	/* a method to remove a product (quantity) from the location
	 * 
	 */
	public void removeProduct() {
		if (product.sell() == true) {//call product sell method
			productsCount--;//reduce count of products
		} else {
			System.out.print("No products");
		}
	}

	////////////////////////////////////////////////////////////////////////////////
	/*a method to give a String representation of a location
	 * @ return String
	 */
	
	public String toString() {
		String toString = "";

		if (this.product == null) {

		} else {
			toString = this.product.getDescription() + ", " + this.position + ", " + this.product.getPrice() + ", "
					+ this.productsCount;//use product count not quantity in case product has been 'topped-up'

		}
		return toString;
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public String display() {
		String toString = "hello";

		if (this.product == null) {

		} else {
			toString = this.product.getDescription() + ", " + this.position + ", " + this.product.getPrice() + ", "
					+ this.productsCount;

		}
		return toString;
	}

///////////////////////////////////////////////////////////////////////////////
	// a method to get product quantity
	public int getProductQuantity() {
		return this.product.getQuantity();
	}

///////////////////////////////////////////////////////////////////////////////////
	//a method to get product name in location
	
	public String getProductName() {
		String name = "Empty";
		if (this.product == null) {

		} else {
			name = this.product.getDescription();
		}
		return name;
	}
/////////////////////////////////////////////////////////////////////////////////////
//a method to get product price in location
	public double getProductprice() {
		double price = 0;
		if (this.product == null) {

		} else {
			price = this.product.getPrice();
		}
		return price;
	}

//////////////////////////////////////////////////////////////////////////////////////
	// a method to get the locationid of product
	
	
	public String getProductLocation() {
		return this.product.getLocationId();
	}
///////////////////////////////////////////////////////////////////////////////////////
}

