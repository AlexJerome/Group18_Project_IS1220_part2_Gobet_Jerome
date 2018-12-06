package RidesPackage;

import CarsPackage.Cars;
import Project.Customer;
import Project.Driver;

/**
 * class which creates rides and calculate prices of rides
 * @author alexandra
 *
 */
public class RidesFactory {
	
	/**
	 * incrementation to count the number of rides
	 */
	public static int incr = 0;
	/**
	 * sum of the prices of all rides
	 */
	public static double sumPrice = 0;
	
	/**
	 * average speed with low, medium, and heavy-traffic
	 */
	public static double[] averageSpeed = {15.0,7.5,3.0};
	/**
	 * create a ride
	 * @param rideType : type of the ride in String
	 * @param startPoint : GPS coordinates of the starting point of the ride
	 * @param destPoint : GPS coordinate of the destination point of the ride
	 * @param cust : customer who booked the ride
	 * @param state : current state of the ride
	 * @return the created ride
	 */
	public static Rides createRide(String rideType, double[] startPoint, double[] destPoint, Customer cust, String state, String traffic) {
		if(rideType == null) {
			return null;
		}
		else if(rideType.equalsIgnoreCase("UberX")) {
			incr += 1;
			return new UberX(startPoint, destPoint, cust, state, traffic);
		}
		else if(rideType.equalsIgnoreCase("UberBlack")) { 
			incr += 1;
			return new UberBlack(startPoint, destPoint, cust, state, traffic);
		}
		else if(rideType.equalsIgnoreCase("UberPool")) {
			incr += 1;
			return new UberPool(startPoint, destPoint, cust, state, traffic);
		}
		else if(rideType.equalsIgnoreCase("UberVan")) {
			incr += 1;
			return new UberVan(startPoint, destPoint, cust, state, traffic);
		}
		return null;
	}

	/**
	 * calculate the prices of a ride
	 * @param traffic : traffic state during the ride
	 * @param length : length of the ride
	 * @return list of prices of the ride 
	 * corresponding to the different types of ride {UberX,UberBlack,UberPool,UberVan}
	 */
	public static double[] evaluatePrices(String traffic, double length) {
		double[] prices  = {UberX.evaluatePrice(traffic, length),UberBlack.evaluatePrice(traffic, length),
				UberPool.evaluatePrice(traffic, length),UberVan.evaluatePrice(traffic, length)};
		return(prices);
	};

	/**
	 * give distribution of probability, given the time
	 * @param hour : hour of the ride
	 * @return distribution of probability
	 */
	public static double[] probaDistribution(int hour) {
		double[] probaDistribution = new double[2];
		if(hour >= 22 && hour < 7 ) {
			probaDistribution[0] = 0.95;
			probaDistribution[1] = 0.04;
		}
		else if(hour >= 7 && hour < 11) {
			probaDistribution[0] = 0.05;
			probaDistribution[1] = 0.20;
		}
		else if(hour >= 11 && hour < 17) {
			probaDistribution[0] = 0.15;
			probaDistribution[1] = 0.7;
		} 
		else {
			probaDistribution[0] = 0.01;
			probaDistribution[1] = 0.04;
		}	
		return(probaDistribution);
	}
	
	/**
	 * give state of traffic at a time
	 * @param hour 
	 * @return state of traffic
	 */
	public static String stateOfTraffic(int hour) {
		double[] probaDistrib = probaDistribution(hour);
		double rand = Math.random();
		if(rand<probaDistrib[0]) {
			return("low");
		}
		else if(rand<probaDistrib[0] + probaDistrib[1]) {
			return("medium");
		}
		else { 
			return("heavy");
		}
	}
}