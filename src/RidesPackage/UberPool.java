package RidesPackage;

import java.util.Scanner;

import CarsPackage.Berline;
import CarsPackage.Cars;
import Project.Customer;
import Project.Driver;

/**
 * class representing the UberPool type of ride
 * @author alexandra
 *
 */
public class UberPool extends Rides {
	/**
	 * basic rates for UberPool
	 */
	static double[] basicRates = {2.4,3,1.3,1.1};
	/**
	 * traffic rates for UberPool
	 */
	static double[] trafficRates = {1,1.1,1.2};

	/**
	 * create an UberPool ride
	 * @param startPoint : starting point of the ride in GPS coordinates
	 * @param destPoint : destination point of the ride in GPS coordinates
	 * @param cust : customer who booked the ride
	 * @param state : current state of the ride
	 */
	public UberPool(double[] startPoint, double[] destPoint, Customer cust, String state, String traffic) {
		super(startPoint, destPoint, cust, state, traffic);
	}


	/**
	 * evaluate the cost of an UberPool ride
	 * @param traffic : traffic state during the ride
	 * @param length : length of the ride
	 * @return cost of the ride
	 */
	public static double evaluatePrice(String traffic, double length) {
		return(Rides.trafficRate(traffic, trafficRates)*length*Rides.basicRate(length, basicRates));
	}
	
	
	//TOSTRING :
	@Override
	public String toString() {
		return "UberPool Ride : " +super.toString();
	}

}
