package Project;

import java.util.GregorianCalendar;

import RidesPackage.Rides;
import RidesPackage.RidesFactory;

/**
 * class giving statistics about elements of the system
 * @author mariongobet
 */

public class Balances {
	
	/**
	 * allow to retrieve the number of rides,
	 * the total time spent on a uber car,
	 * the total amount of charges payed by a given customer
	 * (for allrides performed)
	 * @param customer
	 */
	public static String customerBalance(Customer customer) {
		int countRides = customer.getCountRides();
		double countTimeSpent = customer.getCountTimeSpent();
		double countPrice = customer.getCountPrice();
		String display ="Number of rides for this customer = "+countRides+", total time spent by the customer = "+countTimeSpent+", total of charges for the customer  = "+countPrice;
		return display;
	}
	
	/**
	 * allow to retrieve the total number of rides a driver performed over a given time interval,
	 * as well as the total amount of money cashed by the driver through the rides
	 * allow to compute some key performance indicators like the on-duty rate of driving and the rate of activity
	 * @param driver
	 * @param start : beginning of the time interval
	 * @param end : end of the time interval
	 */
	public static String driverBalance(Driver driver, GregorianCalendar start, GregorianCalendar end) {
		// number of rides
		int countRide = 0;
		for (Rides ride : Rides.rideList) {
			if (ride.getDriver().getDriverID()==driver.getDriverID() && ride.getStartDate().after(start) && ride.getEndDate().before(end)) {
				countRide+=1;
			}
		}
		
		// money cashed
		double countMoney = driver.getCountMoney();
		
		// on-duty rate of driving
		double timeOnARide = driver.getTimeOnARide();
		double timeOnDuty = driver.getTimeOnDuty();
		double rate1 = 1;
		if(timeOnDuty == 0) {throw new ArithmeticException("Division by zero");}
		else {System.out.println(timeOnARide+" "+timeOnDuty);
		rate1 = timeOnARide/timeOnDuty;}
		
		// rate of activity
		double timeOffDuty = driver.getTimeOffDuty();
		double rate2 = 1;
		if (timeOnARide+timeOnDuty+timeOffDuty==0) {throw new ArithmeticException("Division by zero");}
		else {rate2 = (timeOnARide+timeOnDuty)/(timeOnARide+timeOnDuty+timeOffDuty);}
		
		String display = "Number of rides over this interval time = "+countRide+", money cashed by the driver = "+countMoney+", on-duty rate of driving = "+rate1+", activity rate = "+rate2;
		return(display);
	}
	
	/**
	 * allow to retrieve the total number of rides for all drivers,
	 * as well as the total amount of money cashed in by all drivers
	 */
	public static void systemBalance() {
		int countAllRides = RidesFactory.incr;
		double countAllPrices = RidesFactory.sumPrice;
		System.out.println("Number of rides = "+countAllRides+", total charges = "+countAllPrices);
	}

}
