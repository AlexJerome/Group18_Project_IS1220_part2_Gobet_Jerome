package RidesPackage;

import CarsPackage.Cars;
import CarsPackage.Van;
import Project.Customer;
import Project.Driver;

/**
 * class representing the type of ride UberVan
 * @author alexandra
 *
 */
public class UberVan extends Rides {
	/**
	 * basic rates for UberVan
	 */
	static double[] basicRates = {6.2,7.7,3.25,2.6};
	/**
	 * traffic rates for UberVan
	 */
	static double[] trafficRates = {1,1.5,1.8};

	/**
	 * create an UberVan ride
	 * @param startPoint : starting point of the ride in GPS coordinates
	 * @param destPoint : destination point of the ride in GPS coordinates
	 * @param cust : customer who booked the ride
	 * @param state : current state of the ride
	 */
	public UberVan(double[] startPoint, double[] destPoint, Customer cust, String state, String traffic) {
		super(startPoint, destPoint, cust, state, traffic);
	}
	
	/**
	 * evaluate the cost of an UberVan ride
	 * @param traffic : traffic state during the ride
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
			throw new NoDriverAvailable("No Car available for your UberVan ride");
		}
		else {
			for (Cars car : Cars.carList) {
				if (car instanceof Van && car.getOwners().size()>0) {
					for (Driver driver : car.getOwners()) {
						if (driver.getState().equals("onduty")){
							Object[] obj= {driver,car};
							return obj;
						}
					}
				}
			}
		throw new NoDriverAvailable("None Driver available for your UberVan ride");
		}
	}
	
	//TOSTRING :
	@Override
	public String toString() {
		return "UberVan Ride : " +super.toString();
	}
}

