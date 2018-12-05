package CarsPackage;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Project.Driver;

/**
 * @author mariongobet
 *
 */
class CarsFactoryTest {

	/**
	 * Test if the car created has the good type and the good number of seats
	 */
	@Test
	public void testCreateCar() {
		Driver driver = new Driver("John","Johnny");
		ArrayList<Driver> owners = new ArrayList<Driver>();  
		owners.add(driver);
		double coordGPS[] = {3.43,8.20}; 
		String carTypeBerline = "Berline";
		String carTypeStandard = "Standard";
		String carTypeVan = "Van";
		Cars berline = CarsFactory.createCar(carTypeBerline,owners,coordGPS);
		Cars standard = CarsFactory.createCar(carTypeStandard,owners,coordGPS);
		Cars van = CarsFactory.createCar(carTypeVan,owners,coordGPS);
		assertEquals(berline.getClass().toString(),"class Project.Berline");
		assertEquals(standard.getClass().toString(),"class Project.Standard");
		assertEquals(van.getClass().toString(),"class Project.Van");
		assertEquals(berline.getNbSeats(),4);
		assertEquals(standard.getNbSeats(),4);
		assertEquals(van.getNbSeats(),6);
	}

	/**
	 * Test getter for standardIncr
	 */
	@Test
	public void testGetStandardIncr() {
		int standardIncr = CarsFactory.getStandardIncr();
		Driver driver = new Driver("John","Johnny");
		ArrayList<Driver> owners = new ArrayList<Driver>();  
		owners.add(driver);
		double coordGPS[] = {3.43,8.20};
		Cars standard = CarsFactory.createCar("Standard",owners,coordGPS);
		int newStandardIncr = CarsFactory.getStandardIncr();
		assertEquals(standardIncr+1,newStandardIncr);
	}

	/**
	 * Test setter for standardIncr
	 */
	@Test
	public void testSetStandardIncr() {
		CarsFactory.setStandardIncr(24);
		int testStandard = CarsFactory.getStandardIncr();
		assertEquals(testStandard,24);
	}

	/**
	 * Test getter for berlineIncr
	 */
	@Test
	void testGetBerlineIncr() {
		int berlineIncr = CarsFactory.getBerlineIncr();
		Driver driver = new Driver("John","Johnny");
		ArrayList<Driver> owners = new ArrayList<Driver>();  
		owners.add(driver);
		double coordGPS[] = {3.43,8.20};
		Cars berline = CarsFactory.createCar("Berline",owners,coordGPS);
		int newBerlineIncr = CarsFactory.getBerlineIncr();
		assertEquals(berlineIncr+1,newBerlineIncr);
	}

	/**
	 * Test setter for berlineIncr
	 */
	@Test
	void testSetBerlineIncr() {
		CarsFactory.setBerlineIncr(19);
		int testBerline = CarsFactory.getBerlineIncr();
		assertEquals(testBerline,19);
	}

	/**
	 * Test getter for vanIncr
	 */
	@Test
	void testGetVanIncr() {
		int vanIncr = CarsFactory.getVanIncr();
		Driver driver = new Driver("John","Johnny");
		ArrayList<Driver> owners = new ArrayList<Driver>();  
		owners.add(driver);
		double coordGPS[] = {3.43,8.20};
		Cars van = CarsFactory.createCar("Van",owners,coordGPS);
		int newVanIncr = CarsFactory.getVanIncr();
		assertEquals(vanIncr+1,newVanIncr);
	}

	/**
	 * Test setter for vanIncr
	 */
	@Test
	void testSetVanIncr() {
		CarsFactory.setVanIncr(3);
		int testVan = CarsFactory.getVanIncr();
		assertEquals(testVan,3);
	}

}
