package RidesPackage;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Project.Customer;

/**
 * @author mariongobet
 *
 */
class UberPoolTest {

	/**
	 * Test if the thing we created is an UberPool ride
	 */
	@Test
	public void testUberPool() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		double startPoint[] = {8.29,43.01};
		double destPoint[] = {8.43,42.93};
		UberPool uberPool = new UberPool(startPoint,destPoint,customer,"unconfirmed","low");
		assertEquals(uberPool.getClass().toString(),"class RidesPackage.UberPool");
	}

	/**
	 * Test the price of an UberPool ride of 12km with a medium traffic
	 */
	@Test
	public void testEvaluatePrice() {
		double price = UberPool.evaluatePrice("medium",12);
		double expectedPrice = 1.1*12*1.3;
		assertEquals(price,expectedPrice);
	}
}

