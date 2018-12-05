/**
 * 
 */
package Project;

import java.util.Collections;
import java.util.Comparator;

/**
 * @author mariongobet
 *
 */
public class Stats {
	
	public static void mostFrequentCustomer () {
		Collections.sort(Customer.customerList, new Comparator<Customer>() {
		    public int compare(Customer cust1, Customer cust2) {
		        return cust1.getCountRides().compareTo(cust2.getCountRides());
		    }
		});
		
	}
}
