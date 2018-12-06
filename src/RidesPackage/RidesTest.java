package RidesPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RidesTest {

	/**
	 * Test length
	 */
	@Test
	void testLength() {
		double length = Rides.length(new double[] {1.0,1.0},new double[] {1.0,3.0});
		assertEquals(length,2.0);
	}
	
	/**
	 * Test basic rate
	 */
	@Test
	void testBasicRate() {
		double rate = Rides.basicRate(7.3, new double[] {1.0,1.2,1.4,1.7});
		assertEquals(rate,1.2);
	}
	
	/**
	 * Test traffic rate
	 */
	@Test
	void testTrafficRate() {
		double rate = Rides.trafficRate("low", new double[] {4.0,3.4,2.7});
		assertEquals(rate,4.0);
	}

	/**
	 * Test speed
	 */
	@Test
	void testSpeed() {
		double speed = Rides.speed("low");
		assertEquals(speed,15.0);
	}
	
}
