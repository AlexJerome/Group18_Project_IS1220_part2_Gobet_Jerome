package Project;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CarsPackage.Berline;
import CarsPackage.Cars;
import CarsPackage.CarsFactory;

class ClientAppTest {

	/**
	 * tests method addCustomer
	 * the new customer has the correct name and surname
	 */
	@Test
	public void testAddCustomer() {
		ClientApp.addCustomer("CustomerName", "CustomerSurname");
		Customer newCust = Customer.customerList.get(Customer.customerList.size()-1);
		assertEquals(newCust.getName(),"CustomerName");
		assertEquals(newCust.getSurname(),"CustomerSurname");
	}
	/**
	 * tests method addCarDriver
	 * the owner of the new car has correct name and surname
	 * the new car has the correct type
	 */
	@Test
	public void testAddCarDriver() {
		ClientApp.addCarDriver("driverName","driverSurname","Berline");
		Cars newCar = Cars.CarList.get(Cars.CarList.size()-1);
		Driver owner = newCar.getOwners().get(0);
		assertEquals(owner.getName(),"driverName");
		assertEquals(owner.getSurname(),"driverSurname");
		assert(newCar instanceof Berline);
	}
	
	/**
	 * tests method addDriver
	 * the car has a new driver with correct name and surname
	 */
	@Test
	public void testAddDriver() {
		Cars newCar = CarsFactory.createCar("Berline", new ArrayList<Driver>(), ClientApp.randomcoord());
		String carID = newCar.getCarID();
		ClientApp.addDriver("driverName", "driverSurname", carID);
		Driver owner = newCar.getOwners().get(0);
		assertEquals(owner.getName(),"driverName");
		assertEquals(owner.getSurname(),"driverSurname");
	}
	
	@Test
	public void testSetDriverStatus() {
		Driver newDriver = new Driver("driverName","driverSurname");
	}
}
