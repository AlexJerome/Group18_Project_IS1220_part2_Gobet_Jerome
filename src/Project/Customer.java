/**
 * 
 */
package Project;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * class representing customers (people who can book a ride)
 * @author alexandra
 */

public class Customer {
	/**
	 * name of the customer
	 */
	private String name;
	/**
	 * surname of the customer
	 */
	private String surname;
	/**
	 * ID of the customer (in the form : "CustomerN" where N is an unique id)
	 */
	private String custID;
	/**
	 * GPS coordinates of the position of the customer
	 */
	private double[] coordGPS;
	/**
	 * credit card number
	 */
	private long creditCardNb;
	/**
	 * message box
	 */
	private ArrayList<String> msgBox;
	/**
	 * number of rides of the customer
	 */
	private int countRides;
	/**
	 * time spent on an uber car by the customer
	 */
	private double countTimeSpent;
	/**
	 * total amount of charges payed by the customer
	 */
	private double countPrice;
	/**
	 * incrementation to give each customer a unique ID
	 */
	private static Integer incr = 0;
	/**
	 * list of customers
	 */
	public static ArrayList<Customer> customerList = new ArrayList<Customer>();

	// CONSTRUCTOR :
	/**
	 * create a customer
	 * @param name : name of customer
	 * @param surname : surname of customer
	 * @param coordGPS : position of customer
	 * @param creditCardNb : credit card number of customer
	 */
	public Customer(String name, String surname, double[] coordGPS, long creditCardNb) {
		incr += 1;
		this.name = name;
		this.surname = surname;
		this.custID = "Customer" + Integer.toString(incr);
		this.coordGPS = coordGPS;
		this.creditCardNb = creditCardNb;
		this.msgBox = new ArrayList<String>();
		this.countRides = 0;
		this.countTimeSpent = 0.0;
		this.countPrice = 0.0;
		customerList.add(this);
	}
	
	//METHODS :
	public static void setupCustomers(int nCustomers) {
		for(int i =0; i<nCustomers; i++) {
			new Customer("customer"+incr+"name","customer"+incr+"surname",ClientApp.randomcoord(),7896589);
		}
	}

	//GETTERS AND SETTERS :
	/**
	 * get name
	 * @return name : name of customer
	 */
	public String getName() {
		return name;
	}
	/**
	 * set name
	 * @param name : new name of customer
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * get surname
	 * @return surname : surname of customer
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * set surname
	 * @param surname : new surname of customer
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * get ID
	 * @return custID : ID of the customer
	 */
	public String getCustID() {
		return custID;
	}
	/**
	 * get GPS coordinates of customer's position
	 * @return coord GPS : position of the customer
	 */
	public double[] getCoordGPS() {
		return coordGPS;
	}
	/**
	 * set coordGPS
	 * @param coordGPS : new position of the customer
	 */
	public void setCoordGPS(double[] coordGPS) {
		this.coordGPS = coordGPS;
	}
	/**
	 * get CreditCardNb
	 * @return creditCardNb : number of the customer's credit card
	 */
	public long getCreditCardNb() {
		return creditCardNb;
	}
	/**
	 * set CreditCardNb
	 * @param creditCardNb : new number of the customer's credit card
	 */
	public void setCreditCardNb(long creditCardNb) {
		this.creditCardNb = creditCardNb;
	}
	/**
	 * get message box
	 * @return msgBox : list of the messages received by the customer
	 */
	public ArrayList<String> getMsgBox() {
		return msgBox;
	}
	/**
	 * set message box
	 * @param msgBox : new list of messages received by the customer
	 */
	public void setMsgBox(ArrayList<String> msgBox) {
		this.msgBox = msgBox;
	}
	/**
	 * get countRides
	 * @return countRides : number of rides of the customer
	 */
	public int getCountRides() {
		return countRides;
	}
	/**
	 * set countRides
	 * @param countRides : new number of rides of the customer
	 */
	public void setCountRides(int countRides) {
		this.countRides = countRides;
	}
	/**
	 * get countTimeSpent
	 * @return countTimeSpent : time spent on an uber car by the customer
	 */
	public double getCountTimeSpent() {
		return countTimeSpent;
	}

	/**
	 * set countTimeSpend
	 * @param countTimeSpent : new time spent on an uber car by the customer
	 */
	public void setCountTimeSpent(double countTimeSpent) {
		this.countTimeSpent = countTimeSpent;
	}

	/**
	 * get countPrice
	 * @return countPrice : total amount of charges payed by the customer
	 */
	public double getCountPrice() {
		return countPrice;
	}

	/**
	 * set countPrice
	 * @param countPrice : new total amount of charges payed by the customer
	 */
	public void setCountPrice(double countPrice) {
		this.countPrice = countPrice;
	}
	/**
	 * get incr
	 * @return incr : number of customers
	 */
	public static int getIncr() {
		return incr;
	}

	//TOSTRING :
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [name=" + name + ", surname=" + surname + ", custID=" + custID + ", coordGPS="
				+ Arrays.toString(coordGPS) + ", creditCardNb=" + creditCardNb + ", msgBox=" + msgBox + ", countRides="
				+ countRides + ", countTimeSpent=" + countTimeSpent + ", countPrice=" + countPrice + "]";
	}
	
	public static String displayCustomers() {
		String display = "List of customers : \n";
		for(Customer cust : customerList) {
			display+=cust.toString() + "\n";
		}
		return(display);
	}
}
