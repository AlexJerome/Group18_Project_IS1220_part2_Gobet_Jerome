package RidesPackage;

import Project.Customer;

/**
 * class representing the type of ride UberBlack
 * @author alexandra
 *
 */
public class UberBlack extends Rides {
	/**
	 * basic rates for UberBlack
	 */
	static double[] basicRates = {6.2,5.5,3.25,2.6};
	/**
	 * traffic rates for UberBlack
	 */
	static double[] trafficRates = {1,1.3,1.6};

	/**
	 * create an UberBlack ride
	 * @param startPoint : starting point of the ride
	 * @param destPoint : destination point of the ride
	 * @param cust : customer who booked the ride
	 * @param state : current state of the ride
	 */
	public UberBlack(double[] startPoint, double[] destPoint, Customer cust, String state, String traffic) {
		super(startPoint, destPoint, cust, state, traffic);
	}
	
	/**
	 * evaluation of the cost of an UberBlack ride
	 * @param traffic : state of the traffic
	 * @param length : length of the ride
	 * @return cost of the ride
	 */
	public static double evaluatePrice(String traffic, double length) {
		return(Rides.trafficRate(traffic, trafficRates)*length*Rides.basicRate(length, basicRates));
	}
}
