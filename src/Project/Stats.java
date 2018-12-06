/**
 * 
 */
package Project;

import java.util.Collections;
import java.util.Comparator;

import RidesPackage.Rides;

/**
 * @author mariongobet
 *
 */
public class Stats {
	
	class CustomerRideComparator implements Comparator<Customer> {
		@Override
		public int compare(Customer c1, Customer c2) {
			return c1.getCountRides()-c2.getCountRides();
		}
	}
	
	public void mostFrequentCustomer() {
		Collections.sort(Customer.customerList, new CustomerRideComparator());
		for (Customer cust : Customer.customerList) {
			System.out.println("ID = "+cust.getCustID()+", name = "+cust.getName()+", surname = "+cust.getSurname());
		}
	}
	
	class CustomerPriceComparator implements Comparator<Customer> {
		@Override
		public double compare(Customer c1, Customer c2) {
			return c1.getCountPrice()-c2.getCountPrice();
		}
	}
	
	public void mostChargedCustomer() {
		Collections.sort(Customer.customerList, new CustomerPriceComparator());
		for (Customer cust : Customer.customerList) {
			System.out.println("ID = "+cust.getCustID()+", name = "+cust.getName()+", surname = "+cust.getSurname());
		}
	}
	
	
	
}
