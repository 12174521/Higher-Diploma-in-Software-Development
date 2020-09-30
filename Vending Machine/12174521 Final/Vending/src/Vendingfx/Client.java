package Vendingfx;
//Client class extends from User class, has extra field credit
public class Client extends User {
	double credit;
	

/////////////////////////////////////////////////////////////////////////////
	//constructor takes in username, credit amount and password
	public Client(String username,  double credit, String password) {
		super(username, password);
		this.credit = credit;
		this.type = "Client";
	}

////////////////////////////////////////////////////////////////////////////////////

@Override

public String toString() {
	return this.username + " " + this.credit + " " + this.password + " " ;
}
//////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////
/* a method to get the Client's credit
 * @ return  double credit of client
 */

public double getCredit() {
	return this.credit;
}
///////////////////////////////////////////////////////////////////////
/*
 * display credit with the currency
 */
public String displayCredit() {
	return  "€"+ this.credit;
}
///////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////
// a method that allows the client to buy a product it reduces the credit by spend amount abd returns the new credit value.
//@return double credit
public double buy(double spendAmount)throws PurchaseException {
	if(this.credit > spendAmount) {
	this.credit = this.credit - spendAmount;
	}else {
		throw new PurchaseException("Insufficient money");
	}
	return this.credit;
}
///////////////////////////////////////////////////////////////////////////
}