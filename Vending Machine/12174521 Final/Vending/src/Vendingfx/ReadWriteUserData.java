package Vendingfx;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
// a class to read and write the user data into and from the client.csv and admin.csv files.  The data when read if put into 
//arraylist
public class ReadWriteUserData {

	private static ArrayList<User> users;
	private String clientFilename, adminFilename;//filepaths needed for reading and writing.

	public ReadWriteUserData(String clientFilename, String adminFilename) {//the filenames/paths are taken in the constructor)
		users = new ArrayList<User>();
		this.clientFilename = clientFilename;
		this.adminFilename = adminFilename;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////
//a method to read the clients file into the user arraylist
	public void readClients() throws FileNotFoundException {

		String csvFile = this.clientFilename;
		String line = "";
		String cvsSplitBy = ", ";//use comma as separator

		try (BufferedReader clientInput = new BufferedReader(new FileReader(csvFile))) {

			while ((line = clientInput.readLine()) != null) {
				String pattern = "[0-9]{6}";//check passwords are in correct 6 number format
				String[] userData = line.split(cvsSplitBy);

				String username = userData[0];
				Double credit = Double.parseDouble(userData[1]);
				String password = userData[2];
				if (!password.matches(pattern)) {
					System.out.println("Invalid password format");//check passwords are 6 numbers
					}
				users.add(new Client(username, credit, password));//add the usernames and password to the arraylist as new users

			}

		} catch (IOException e) {
			System.out.print("No file found");
		}

	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Data input alternative
	/*
	 * DataInputStream userinput = new DataInputStream(new
	 * FileInputStream("src/Vendingfx/Clients.csv"))){ boolean eof = false;
	 * while(!eof) { String username = userinput.readUTF(); String password =
	 * userinput.readUTF(); double credit = userinput.readDouble();
	 * System.out.print(credit); System.out.print(password);
	 * System.out.print(username); System.out.print("hello"); users.add(new
	 * Client(username, password, credit));
	 * 
	 * } catch (EOFException ex) { System.out.println("All data were read"); } catch
	 * (IOException ex) { ex.printStackTrace();
	 */

/////////////////////////////////////////////////////////////////////////////////////////////////
	//a mthod to read the admin file into the arraylist of users
	public void readAdmin() throws FileNotFoundException {

		String csvFile = adminFilename;
		String line = "";
		String cvsSplitBy = ", ";

		try (BufferedReader adminInput = new BufferedReader(new FileReader(csvFile))) {

			while ((line = adminInput.readLine()) != null) {
				String pattern = "[0-9]{6}";//pattern to check that userpasswords are formatted correctly of 6 numbers
				
				// use comma as separator

				String[] userData = line.split(cvsSplitBy);
			

				String username = userData[0];
				
				String password = userData[1];
				if (!password.matches(pattern)) {
					System.out.println("Invalid password format");//check passwords are 6 numbers
					}
					

				users.add(new Admin(username, password));//make sure they are admin objects

			}

		} catch (IOException e) {
			System.out.print("Enter valid Admin.csv");
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
//a method to get client credit
	//@ return double  client credit
	public double getClientCredit(int client) {
		return ((Client) users.get(client)).getCredit();
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////
// a method to write the client details back to the client.csv
	public void writeClients() throws IOException {
	

		try (PrintWriter output = new PrintWriter(this.clientFilename);)// ("src/Vendingfx/Clients.csv");)

		{
//loop through array list and  read output back to file
			for (int i = 0; i < users.size(); i++) {
				if (getUserType(i).equalsIgnoreCase("client")) {//only write back users that are clients
					output.printf("%s, %.2f, %s%n", getUsername(i), getCredit(i), getPassword(i));
				}

			}
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////
	//a method to write the admin data back to admin.csv file
	public void writeAdmin() throws IOException {
	
		try (PrintWriter output = new PrintWriter(this.adminFilename);)// ("src/Vendingfx/Admin.csv");)

		{

			for (int i = 0; i < users.size(); i++) {
				if (getUserType(i).equalsIgnoreCase("admin")) {//only write back users that are admin
					output.printf("%s, %s%n", getUsername(i), getPassword(i));
				}

			}
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////
	// a method to get the user type at the index
	//@ return String userType
	//@ param int user index number
	public String getUserType(int i) {
		return users.get(i).getUserType();
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////
	/*a method to get the Arraylist
	 * @ return Arraylist users
	 */
	
	public ArrayList<User> getArray() {
		return users;
	}
	///////////////////////////////////////////////////////////////////////////////////////////
/*A method to display the list for testing
 * 
 */
	public void displayList() {
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).toString());
		}
	}
////////////////////////////////////////////////////////////////
// a method to log users in by authenticating their userame and password
	//@return the index of the user when a match is found
	public int login(String username, String password) throws FileNotFoundException {

		int userIndexNumber = -1;
		for (int i = 0; i < users.size(); i++) {

			if (users.get(i).authenticate(username, password) == true) {//use user authenticate method to check username and password
				userIndexNumber = i;
				break;
			}

			else if (i == (users.size() - 1) && (users.get(i).authenticate(username, password) == false)) {//user not found, index -1
			}
		}
		return userIndexNumber;//return their index number
	}
	/////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////////////
	/*a method to get username
	 * @ String username
	 * @ param int userindex number
	 */
	public String getUsername(int i) {
		return users.get(i).getUsername();
	}

	////////////////////////////////////////////////////////////////////////////
	/*a method to get user password
	 * @ return userPaswword
	 */
	public String getPassword(int i) {
		return users.get(i).getUserPassword();
	}
	//////////////////////////////////////////////////////////////////////////
/*a method to get a users credit
 * @ return double credit
 * @ param int user indexnumber
 */
	public Double getCredit(int i) {
		return ((Client) users.get(i)).getCredit();
	}
	
/////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
//option read and write files as data stream to be more 'efficient'
/*public void readAdmin() {

try(
DataInputStream userinput = new DataInputStream(new FileInputStream("src/Vendingfx/Admin.csv"))){
boolean eof = false;
while(!eof) {
String username = userinput.readUTF();
String password = userinput.readUTF();
//users.add(new User(username, password));
}
}
catch (EOFException ex) {
System.out.println("All data were read");
}
catch (IOException ex) {
ex.printStackTrace();

}
}*/
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
}

