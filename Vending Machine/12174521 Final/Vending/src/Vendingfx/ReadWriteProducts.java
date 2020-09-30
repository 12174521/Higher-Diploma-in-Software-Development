package Vendingfx;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
// a class to read and write the product,csv file into an arraylist of products
public class ReadWriteProducts {
	private ArrayList<Product>products;
	private String productsFilename;//name/path of the file used


	public ReadWriteProducts(String productsFilename) {//constructor takes in the file name.
		
		products = new ArrayList<Product>();
		this.productsFilename = productsFilename;
	}



////////////////////////////////////////////////////////////////////////////////////////////////////
// a method to read the product data from the products.csv to an arraylist
	
	public void readProducts() throws FileNotFoundException {
	String csvFile = this.productsFilename;//"src/Vendingfx/Clients.csv";
    String line = "";
    String cvsSplitBy = ", ";//use comma seperator

    try (BufferedReader productInput = new BufferedReader(new FileReader(csvFile))) {

        while ((line = productInput.readLine()) != null) {
        	String[] productData =  line.split(cvsSplitBy);
        	String productName = productData[0];
        	String productLocation = productData[1];
        	Double price = Double.parseDouble(productData[2]);
        	int quantity = Integer.parseInt(productData[3]);
        	products.add(new Product(productName, productLocation, price, quantity));//add product object to arraylist
        }
    } catch (IOException e) {
        System.out.print("Enter a valid Products file");;
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////
/*a method to get the arraylist
 * @ return arraylist products
 */
public ArrayList<Product> getArrayProd (){
	return products;
}
////////////////////////////////////////////////////////////////////////////////////////////////

	
///////////////////////////////////////////////////////////////////////////////////////////////////
/*a method to get the name of the product at the index
 * @ return String name
 * @ param int index
 */
public String getName(int index) {
	String name = products.get(index).getDescription();
	return name;
}
///////////////////////////////////////////////////////////////////////////////////////////////////
/*a method to get location of product at specified index
 * @ return String location 
 * @ param int product index
 */
public String getLocation(int index) {
	String location = products.get(index).getLocationId();
	return location;
}
//////////////////////////////////////////////////////////////////////////////////////////////
/*a method to get the price of the product at the index
 * @ return double price
 * @ param int index
 */
public double getPrice(int index) {
	double price = products.get(index).getPrice();
	return price;
	
}
/////////////////////////////////////////////////////////////////////////////////////////////////////
/*a method to get the quantity of product at the index
 * @ return int quantity
 * @ param int index
 */
public int getQuantity(int index) {
	int quantity = products.get(index).getQuantity();
	return quantity;
}
/////////////////////////////////////////////////////////////////////////////////////////////////////
// a void method to display list for testing

public void displayList() {
	for (int i = 0; i<products.size(); i++) {
	System.out.println(products.get(i).toString());
	}
}
}