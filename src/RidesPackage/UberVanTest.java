package RidesPackage;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Project.Customer;

/**
 * @author mariongobet
 *
 */
class UberVanTest {

	/**
	 * Test if the thing we created is an UberVan ride
	 */
	@Test
	public void testUberVan() {
		double coordGPS[] = {4.703,9.239};
		Customer customer = new Customer("Jack","Jacky",coordGPS,320971093142937l);
		double startPoint[] = {8.29,43.01};
		double destPoint[] = {8.43,42.93};
		UberVan uberVan = new UberVan(startPoint,destPoint,customer,"unconfirmed","low");
		assertEquals(uberVan.getClass().toString(),"class RidesPackage.UberVan");
	}

	/**
	 * Test the price of an UberVan ride of 3km with a heavy traffic
	 */
	@Test
	public void testEvaluatePrice() {
		double price = UberVan.evaluatePrice("heavy",3);
		double expectedPrice = 1.8*3*6.2;
		assertEquals(price,expectedPrice);
	}

}
