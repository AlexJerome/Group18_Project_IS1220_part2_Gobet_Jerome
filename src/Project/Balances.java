package Project;

import java.util.Date;

import RidesPackage.Rides;

public class Balances {
	
	
	public static void customerBalance(Customer customer) {
		int countRides = customer.getCountRides();
		double countTimeSpent = customer.getCountTimeSpent();
		double countPrice = customer.getCountPrice();
		System.out.println("Number of rides for this customer = "+countRides+", total time spent by the customer = "+countTimeSpent+", total of charges for the customer  = "+countPrice);
	}
	
	public static void driverBalance(Driver driver, Date start, Date end) {
		// number of rides
		int countRide = 0;
		for (Rides ride : Rides.rideList) {
		}
		
		// money cashed
		int countMoney = driver.getCountMoney();
		
		// on-duty rate of driving
		double timeOnARide = driver.getTimeOnARide();
		double timeOnDuty = driver.getTimeOnDuty();
		double rate1 = 1;
		if(timeOnDuty == 0) {throw new ArithmeticException("Division by zero");}
		else {rate1 = timeOnARide/timeOnDuty;}
		
		// rate of activity
		double timeOffDuty = driver.getTimeOffDuty();
		double rate2 = 1;
		if (timeOnARide+timeOnDuty+timeOffDuty==0) {throw new ArithmeticException("Division by zero");}
		else {rate2 = (timeOnARide+timeOnDuty)/(timeOnARide+timeOnDuty+timeOffDuty);}
	}
	
	public static void systemBalance() {
		int countAllRides = Rides.getCountAllRides();
		double countAllPrices = Rides.getCountAllPrices();
		System.out.println("Number of rides = "+countAllRides+", total charges = "+countAllPrices);
	}

}
