package RidesPackage;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Project.Customer;

/**
 * @author mariongobet
 *
 */
class UberXTest {

	/**
	 * Test if the thing we created is an UberX ride
	 */
	@Test
	public void testUberX() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		double startPoint[] = {8.29,43.01};
		double destPoint[] = {8.43,42.93};
		UberX uberX = new UberX(startPoint,destPoint,customer,"unconfirmed","low");
		assertEquals(uberX.getClass().toString(),"class Project.UberX");
	}

	/**
	 * Test the price of an UberX ride of 22km with a heavy traffic
	 */
	@Test
	public void testEvaluatePrice() {
		double price = UberX.evaluatePrice("heavy",22);
		double expectedPrice = 1.5*22*1.5;
		assertEquals(price,expectedPrice);
	}

}
