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
		assertEquals(berline.getClass().toString(),"class CarsPackage.Berline");
		assertEquals(standard.getClass().toString(),"class CarsPackage.Standard");
		assertEquals(van.getClass().toString(),"class CarsPackage.Van");
		assertEquals(berline.getNbSeats(),4);
		assertEquals(standard.getNbSeats(),4);
		assertEquals(van.getNbSeats(),6);
	}

}
