package CarsPackage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Project.Driver;
/**
 * @author mariongobet
 */
class BerlineTest {
	/**
	 * Test if the thing we created is a Berline
	 */
	@Test
	public void testBerline() {
		Driver driver = new Driver("John","Johnny");
		ArrayList<Driver> owners = new ArrayList<Driver>();  
		owners.add(driver);
		double coordGPS[] = {3.43,8.20}; 
		Berline berline = new Berline (owners,4,"Berline23",coordGPS);
	    assertEquals(berline.getClass().toString(),"class CarsPackage.Berline"); 
	}
	
	/**
	 * Test if 20 Berline cars have been created
	 */
	@Test
	public void testSetUpCars() {
		int nbInit = Berline.incr;
		Berline.setupCars(20);
		int nbFin = Berline.incr;
		assertEquals(nbInit+20,nbFin);
	}
}

