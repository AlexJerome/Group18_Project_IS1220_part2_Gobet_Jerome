package RidesPackage;

import CarsPackage.Cars;
import CarsPackage.Standard;
import Project.Customer;
import Project.Driver;

/**
 * class representing the type of ride UberX
 * @author alexandra
 *
 */
public class UberX extends Rides {
	/**
	 * basic rates for UberX
	 */
	static double[] basicRates = {3.3,4.2,1.91,1.5};
	/**
	 * traffic rates for UberX
	 */
	static double[] trafficRates = {1,1.1,1.5};

	/**
	 * create an UberX ride
	 * @param startPoint : starting point of the ride in GPS coordinates
	 * @param destPoint : destination point of the ride in GPS coordinates
	 * @param cust : customer who booked the ride
	 * @param state : current state of the ride
	 */
	public UberX(double[] startPoint, double[] destPoint, Customer cust, String state, String traffic) {
		super(startPoint, destPoint, cust, state, traffic);
	}
	
	/**
	 * calculate the cost of an UberX ride
	 * @param traffic : traffic state of the ride
	 * @param length : length of the ride
	 * @return cost of the ride
	 */
	public static double evaluatePrice(String traffic, double length) {
		return(Rides.trafficRate(traffic, trafficRates)*length*Rides.basicRate(length, basicRates));
	}
	
	/**
	 * find a Driver and a Car which belongs to the request and are available
	 * @return driver,car
	 * @throws NoDriverAvailable
	 */
	public static Object[] findDriver () throws NoDriverAvailable {
		if (Cars.carList.size()==0) {
			throw new NoDriverAvailable("No Car available for your UberX ride");
		}
		else {
			for (Cars car : Cars.carList) {
				if (car instanceof Standard && car.getOwners().size()>0) {
					for (Driver driver : car.getOwners()) {
						if (driver.getState().equals("onduty")){
							Object[] obj= {driver,car};
							return obj;
						}
					}
				}
			}
		throw new NoDriverAvailable("None Driver available for your UberX ride");
		}
	}
	
	
	//TOSTRING :
	@Override
	public String toString() {
		return "UberX Ride : " + super.toString();
	}

}

