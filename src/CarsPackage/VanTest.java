package CarsPackage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Project.Driver;
/**
 * @author mariongobet
 */
class VanTest {
	/**
	 * Test if the thing we created is a Van
	 */
	@Test
	public void testVan() {
		Driver driver = new Driver("John","Johnny");
		ArrayList<Driver> owners = new ArrayList<Driver>();  
		owners.add(driver);
		double coordGPS[] = {5.38,28.21}; 
		Van van = new Van(owners,6,"Van52",coordGPS);
	    assertEquals(van.getClass().toString(),"class CarsPackage.Van"); 
	}
	
	/**
	 * Test if 7 Van have been created
	 */
	@Test
	public void testSetUpCars() {
		int nbInit = Van.incr;
		Van.setupCars(7);
		int nbFin = Van.incr;
		assertEquals(nbInit+7,nbFin);
	}
}
