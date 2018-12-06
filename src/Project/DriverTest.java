package Project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author mariongobet
 *
 */
class DriverTest {

	/**
	 * Test if the thing we created is a Driver
	 */
	@Test
	public void testDriver() {
		Driver driver = new Driver("William","Willy");
		assertEquals(driver.getClass().toString(),"class Project.Driver");
	}
	
	
	/**
	 * Test if setupDrivers create the exact number of drivers
	 */
	@Test
	public void testSetupDrivers() {
		int currentNumberOfDrivers = Driver.driverList.size();
		Driver.setupDrivers(5);
		assertEquals(currentNumberOfDrivers + 5, Driver.driverList.size());
	}

	/**
	 * Test getter for name
	 */
	@Test
	public void testGetName() {
		Driver driver = new Driver("William","Willy");
		assertEquals(driver.getName(),"William");
	}

	/**
	 * Test setter for name
	 */
	@Test
	public void testSetName() {
		Driver driver = new Driver("William","Willy");
		driver.setName("John");
		assertEquals(driver.getName(),"John");
	}

	/**
	 * Test getter for surname
	 */
	@Test
	public void testGetSurname() {
		Driver driver = new Driver("William","Willy");
		assertEquals(driver.getSurname(),"Willy");
	}

	/**
	 * Test setter for surname
	 */
	@Test
	public void testSetSurname() {
		Driver driver = new Driver("William","Willy");
		driver.setSurname("Johnny");
		assertEquals(driver.getSurname(),"Johnny");
	}

	/**
	 * Test getter for ID
	 */
	@Test
	public void testGetDriverID() {
		Driver driver = new Driver("William","Willy");
		assertEquals(driver.getDriverID().toString(),"Driver"+Integer.toString(Driver.getIncr()));
	}

	/**
	 * Test getter for state
	 */
	@Test
	public void testGetState() {
		Driver driver = new Driver("William","Willy");
		assertEquals(driver.getState(),"offline");
	}

	/**
	 * Test setter for state
	 */
	@Test
	public void testSetState() {
		Driver driver = new Driver("William","Willy");
		driver.setState("on-a-ride");
		assertEquals(driver.getState(),"on-a-ride");
	}
	
	/**
	 * Test getter for incr
	 */
	@Test
	public void testGetIncr() {
		int incr = Driver.getIncr();
		new Driver("William","Willy");
		int newIncr = Driver.getIncr();
		assertEquals(incr+1,newIncr);
	}
}
