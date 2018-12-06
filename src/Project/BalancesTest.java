package Project;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

class BalancesTest {

	@Test
	void  testDriverBalance() {
		Driver driver = new Driver("John","Johnny");
		driver.setTimeOffDuty(4.0);
		driver.setTimeOnARide(6.0);
		driver.setTimeOnDuty(10.0);
		driver.setTimeOffline(12.0);
		assertEquals("Number of rides over this interval time = 0, money cashed by the driver = 0.0, on-duty rate of driving = 0.6, activity rate = 0.8",Balances.driverBalance(driver,new GregorianCalendar(),new GregorianCalendar()));
	}

}
