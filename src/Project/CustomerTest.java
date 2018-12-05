/**
 * 
 */
package Project;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * @author mariongobet
 *
 */
class CustomerTest {

	/**
	 * Test if the thing we created is a Customer
	 */
	@Test
	public void testCustomer() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		assertEquals(customer.getClass().toString(),"class Project.Customer"); 
	}

	/**
	 * Test getter for name
	 */
	@Test
	public void testGetName() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		assertEquals(customer.getName().toString(),"Jack");
	}

	/**
	 * Test setter for name
	 */
	@Test
	public void testSetName() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		customer.setName("John");
		assertEquals(customer.getName().toString(),"John");
	}

	/**
	 * Test getter for surname
	 */
	@Test
	public void testGetSurname() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		assertEquals(customer.getSurname().toString(),"Jacky");
	}

	/**
	 * Test setter for surname
	 */
	@Test
	public void testSetSurname() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		customer.setSurname("Johnny");
		assertEquals(customer.getSurname().toString(),"Johnny");
	}

	/**
	 * Test getter for custID
	 */
	@Test
	public void testGetCustID() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		assertEquals(customer.getCustID().toString(),"Customer"+Integer.toString(Customer.getIncr()));
	}

	/**
	 * Test getter for coordGPS 
	 */
	@Test
	public void testGetCoordGPS() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		assertEquals(customer.getCoordGPS(),coordGPS);
	}

	/**
	 * Test setter for coordGPS
	 */
	@Test
	public void testSetCoordGPS() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		double newCoordGPS[] = {0.293,1.856};
		customer.setCoordGPS(newCoordGPS);
		assertEquals(customer.getCoordGPS(),newCoordGPS);
	}

	/**
	 * Test getter for creditCardNb
	 */
	@Test
	public void testGetCreditCardNb() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		assertEquals(customer.getCreditCardNb(),320971093142937l);
	}

	/**
	 * Test setter for creditCardNb
	 */
	@Test
	public void testSetCreditCardNb() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		customer.setCreditCardNb(6097409212424114l);
		assertEquals(customer.getCreditCardNb(),6097409212424114l);
	}

	/**
	 * Test getter for msgBox
	 */
	@Test
	public void testGetMsgBox() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		ArrayList<String> test = new ArrayList<String>();
		assertEquals(customer.getMsgBox(),test);
	}

	/**
	 * Test setter for msgBox
	 */
	@Test
	public void testSetMsgBox() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		ArrayList<String> test = new ArrayList<String>();
		test.add("Welcome !");
		customer.setMsgBox(test);
		assertEquals(customer.getMsgBox(),test);
	}

	/**
	 * Test getter for countRides
	 */
	@Test
	public void testGetCountRides() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		assertEquals(customer.getCountRides(),0);
	}

	/**
	 * Test setter for countRides
	 */
	@Test
	public void testSetCountRides() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		customer.setCountRides(4);
		assertEquals(customer.getCountRides(),4);
	}

	/**
	 * Test getter for countTimeSpent
	 */
	@Test
	public void testGetCountTimeSpent() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		assertEquals(customer.getCountTimeSpent(),0.0);
	}

	/**
	 * Test setter for countTimeSpent
	 */
	@Test
	public void testSetCountTimeSpent() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		customer.setCountTimeSpent(19.56);
		assertEquals(customer.getCountTimeSpent(),19.56);
	}
	/**
	 * Test getter for countPrice
	 */
	@Test
	public void testGetCountPrice() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		assertEquals(customer.getCountPrice(),0.0);
	}

	/**
	 * Test setter for countPrice
	 */
	@Test
	public void testSetCountPrice() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		customer.setCountPrice(8.33);
		assertEquals(customer.getCountPrice(),8.33);
	}

}
