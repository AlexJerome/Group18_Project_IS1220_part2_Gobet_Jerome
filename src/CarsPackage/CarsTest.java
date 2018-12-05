package CarsPackage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Project.Driver;

/**
 * @author mariongobet
 */
class CarsTest {
	
	/**
	 * Test getter for owners
	 */
	@Test
	public void testGetOwners() {
		Driver driver = new Driver("John","Johnny");
		ArrayList<Driver> owners = new ArrayList<Driver>();  
		owners.add(driver);
		double coordGPS[] = {3.43,8.20}; 
		Berline berline = new Berline (owners,4,"Berline23",coordGPS);
		assertEquals(berline.getOwners(),owners);
	}

	/**
	 * Test setter for owners
	 */
	@Test
	public void testSetOwners() {
		Driver driver = new Driver("John","Johnny");
		ArrayList<Driver> owners = new ArrayList<Driver>();  
		owners.add(driver);
		double coordGPS[] = {3.43,8.20}; 
		Berline berline = new Berline (owners,4,"Berline23",coordGPS);
		Driver driver2 = new Driver("John2","Johnny2"); 
		owners.add(driver2);
		berline.setOwners(owners);
		assertEquals(berline.getOwners(),owners);
	}

	/**
	 * Test getter for nbSeats
	 */
	@Test
	public void testGetNbSeats() {
		Driver driver = new Driver("John","Johnny");
		ArrayList<Driver> owners = new ArrayList<Driver>();  
		owners.add(driver);
		double coordGPS[] = {3.43,8.20}; 
		Berline berline = new Berline (owners,4,"Berline23",coordGPS);
		assertEquals(berline.getNbSeats(),4);
	}

	/**
	 * Test setter for nbSeats
	 */
	@Test
	public void testSetNbSeats() {
		Driver driver = new Driver("John","Johnny");
		ArrayList<Driver> owners = new ArrayList<Driver>();  
		owners.add(driver);
		double coordGPS[] = {3.43,8.20}; 
		Berline berline = new Berline (owners,4,"Berline23",coordGPS);
		berline.setNbSeats(6);
		assertEquals(berline.getNbSeats(),6);
	}

	/**
	 * Test getter for carID
	 */
	@Test
	public void testGetCarID() {
		Driver driver = new Driver("John","Johnny");
		ArrayList<Driver> owners = new ArrayList<Driver>();  
		owners.add(driver);
		double coordGPS[] = {3.43,8.20}; 
		Berline berline = new Berline (owners,4,"Berline23",coordGPS);
		assertEquals(berline.getCarID(),"Berline23");
	}

	/**
	 * Test getter for coordGPS
	 */
	@Test
	public void testGetCoordGPS() {
		Driver driver = new Driver("John","Johnny");
		ArrayList<Driver> owners = new ArrayList<Driver>();  
		owners.add(driver);
		double coordGPS[] = {3.43,8.20}; 
		Berline berline = new Berline (owners,4,"Berline23",coordGPS);
		assertEquals(berline.getCoordGPS(),coordGPS);
	}

	/**
	 * Test setter for coordGPS
	 */
	@Test
	public void testSetCoordGPS() {
		Driver driver = new Driver("John","Johnny");
		ArrayList<Driver> owners = new ArrayList<Driver>();  
		owners.add(driver);
		double coordGPS[] = {3.43,8.20}; 
		Berline berline = new Berline (owners,4,"Berline23",coordGPS);
		double newCoordGPS[] = {58.3,45.2};
		berline.setCoordGPS(newCoordGPS);
		assertEquals(berline.getCoordGPS()[0],58.3);
		assertEquals(berline.getCoordGPS()[1],45.2);
	}
}
