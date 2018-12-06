package RidesPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RidesFactoryTest {

	@Test
	void testEvaluatePrices() {
		double[] prices = RidesFactory.evaluatePrices("medium",3.0);
		assertTrue(prices[0]-3.3*3.0*1.1<Math.pow(10,-10));
		assertTrue(prices[1]-6.2*3.0*1.3<Math.pow(10,-10));
		assertTrue(prices[2]-2.4*3.0*1.1<Math.pow(10,-10));
		assertTrue(prices[3]-6.2*3.0*1.5<Math.pow(10,-10));
	}

}
