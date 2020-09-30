package Vendingfx;

/*A User class that has a username and password
 * 
 */
public class User {
	protected String username;
	protected String password;
	protected String type;

	//////////////////////////////////////////////////////////////////////
	public User() {

	}

	// constructor that takes in the chosen username and password
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.type = null;

		////
	}
/////////////////////////////////////////////////////////////////////////

	
////////////////////////////////////////////////////////////////////////////////////
// A method to set the username if needed
	public void setUsername(String username) {
		this.username = username;
	}

///////////////////////////////////////////////////////////////////////////////////
// a mehtod to get the username
	// @ return String username
	public String getUsername() {
		return this.username;
	}

	////////////////////////////////////////////////////////////////////////////////////
	// a method to get the password
	public String getUserPassword() {
		return this.password;
	}
	///////////////////////////////////////////////////////////////////////////////////
	// a method to set the password if needed
	public void setUserPassword(String password) {
		this.password = password;
	}
	
/////////////////////////////////////////////////////////////////////////////////////
// a method to authenticate username an password, check against inputted username and password
	public boolean authenticate(String username, String password) {
		boolean match = false;

		if (this.username.equals(username) && this.password.equals(password)) {

			match = true;
		}
		return match;
	}

//////////////////////////////////////////////////////////////////////////////////////
// a method to give a string representation of the user
	public String toString() {
		return this.username + " " + this.password;
	}

	

	////////////////////////////////////////////////////////////////////////////////////
	//a method to get the user type
	public String getUserType() {

		return this.type;
	}
	//////////////////////////////////////////////////////////////////////////
}
