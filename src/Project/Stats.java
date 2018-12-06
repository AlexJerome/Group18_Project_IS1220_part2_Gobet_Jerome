/**
 * 
 */
package Project;

import java.util.Collections;
import java.util.Comparator;

import RidesPackage.Rides;

/**dg
 * @author mariongobet
 *
 */
public class Stats {
	
	/**
	 * class used to compare number of rides of customers
	 * @author alexandra
	 *
	 */
	static class CustomerRideComparator implements Comparator<Customer> {
		@Override
		public int compare(Customer c1, Customer c2) {
			return c1.getCountRides()-c2.getCountRides();
		}
	}
	/**
	 * displays the current list of customer sorted by the frequency of rides
	 * (min to max)
	 */
	public static void mostFrequentCustomer() {
		Collections.sort(Customer.customerList, new CustomerRideComparator());
		for (Customer cust : Customer.customerList) {
			System.out.println("ID = "+cust.getCustID()+", name = "+cust.getName()+", surname = "+cust.getSurname());
		}
	}
	
	/**
	 * class uses to compare price paid by customers
	 * @author alexandra
	 *
	 */
	static class CustomerPriceComparator implements Comparator<Customer> {
		@Override
		public int compare(Customer c1, Customer c2) {
			return (int) (c1.getCountPrice()-c2.getCountPrice())*100;
		}
	}
	
	/**
	 * displays the current list of customers sorted by price paid since the creation of their account
	 * the first client displayed has paid the minimum price
	 */
	public static void mostChargedCustomer() {
		Collections.sort(Customer.customerList, new CustomerPriceComparator());
		for (Customer cust : Customer.customerList) {
			System.out.println("ID = "+cust.getCustID()+", name = "+cust.getName()+", surname = "+cust.getSurname());
		}
	}
	
	/**
	 * class used to compare driver activity 
	 * @author alexandra
	 *
	 */
	static class DriverActivityComparator implements Comparator<Driver> {
		@Override
		public int compare(Driver d1, Driver d2) {
			double a1 = d1.getTimeOnARide();
			double a2 = d2.getTimeOnARide();
			double b1 = d1.getTimeOnDuty();
			double b2 = d2.getTimeOnDuty();
			double c1 = d1.getTimeOffDuty();
			double c2 = d2.getTimeOffDuty();
			double rate1 = (a1+b1)/(a1+b1+c1);
			double rate2 = (a2+b2)/(a2+b2+c2);
			return (int) (rate1 - rate2)*(10^10);
		}
	}
	
	/**
	 * displays the list of drivers sorted by the time of occupation
	 */
	public static void leastOccupiedDriver() {
		Collections.sort(Driver.driverList, new DriverActivityComparator());
		for (Driver d : Driver.driverList) {
			System.out.println("ID = "+d.getDriverID()+", name = "+d.getName()+", surname = "+d.getSurname());
		}
	}
	
	/**
	 * class comparing appreciations of drivers
	 * @author alexandra
	 *
	 */
	static class DriverAppreciationsComparator implements Comparator<Driver> {
		@Override
		public int compare(Driver d1, Driver d2) {
			return (int) (d1.getAppreciation()-d2.getAppreciation())*(10^10);
		}
	}
	
	/**
	 * displays the list of drivers sorted from the last appreciated to the most appreciated
	 */
	public static void mostAppreciatedDriver() {
		Collections.sort(Driver.driverList, new DriverAppreciationsComparator());
		for (Driver d : Driver.driverList) {
			System.out.println("ID = "+d.getDriverID()+", name = "+d.getName()+", surname = "+d.getSurname());
		}
	}
	
	/**
	 * calculates the total amount charged by all the drivers
	 * @return total amount
	 */
	public static double totalAmountCharged() {
		double amount = 0.0;
		for(Driver driver: Driver.driverList) {
			amount+= driver.getCountMoney();
		}
		return(amount);
	}
}
