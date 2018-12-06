package RidesPackage;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Project.Customer;

/**
 * @author mariongobet
 *
 */
class UberBlackTest {

	/**
	 * Test if the thing we created is an UberBlack ride
	 */
	@Test
	public void testUberBlack() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		double startPoint[] = {8.29,43.01};
		double destPoint[] = {8.43,42.93};
		UberBlack uberBlack = new UberBlack(startPoint,destPoint,customer,"unconfirmed","low");
		assertEquals(uberBlack.getClass().toString(),"class RidesPackage.UberBlack");
	}

	/**
	 * Test the price of an UberBlack ride of 7km with a low traffic
	 */
	@Test
	public void testEvaluatePrice() {
		double price = UberBlack.evaluatePrice("low",7);
		double expectedPrice = 1*7*5.5;
		assertEquals(price,expectedPrice);
	}

}

