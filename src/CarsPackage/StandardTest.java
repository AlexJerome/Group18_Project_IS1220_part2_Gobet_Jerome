package CarsPackage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Project.Driver;
/**
 * @author mariongobet
 */
class StandardTest {
	/**
	 * Test if the thing we created is a Standard car
	 */
	@Test
	public void testStandard() {
		Driver driver = new Driver("John","Johnny");
		ArrayList<Driver> owners = new ArrayList<Driver>();  
		owners.add(driver);
		double coordGPS[] = {4.09,41.9}; 
		Standard standard = new Standard (owners,4,"Standard1",coordGPS);
	    assertEquals(standard.getClass().toString(),"class CarsPackage.Standard"); 
	}
	
	/**
	 * Test if 12 Standard cars have been created
	 */
	@Test
	public void testSetUpCars() {
		int nbInit = Standard.incr;
		Standard.setupCars(12);
		int nbFin = Standard.incr;
		assertEquals(nbInit+12,nbFin);
	}
}
