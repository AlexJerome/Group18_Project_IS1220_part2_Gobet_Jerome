/**
 * 
 */
package Project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author mariongobet
 *
 */
class StatsTest {
	
	/**
	 * Test if the Customer are well sorted by number of rides
	 */
	@Test
	void testMostFrequentCustomer() {
		Customer.setupCustomers(3);
		Customer.customerList.get(0).setCountRides(4);
		Customer.customerList.get(1).setCountRides(2);
		Customer.customerList.get(2).setCountRides(5);
		Stats.mostFrequentCustomer();
		assertEquals(Customer.customerList.get(0).getCountRides(),2);
		assertEquals(Customer.customerList.get(1).getCountRides(),4);
		assertEquals(Customer.customerList.get(2).getCountRides(),5);
	}

}
