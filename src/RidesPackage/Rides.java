package RidesPackage;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

import CarsPackage.Cars;
import Project.Customer;
import Project.Driver;

/** abstract class which is a template for all kind of rides (UberX, UberVan, UberBlack, UberPool)
	 * allows to create rides, and to calculate rates for implementing the cost of a ride
	 * @author alexandra
	 */

public abstract class Rides {
	/** 
	  * starting point of the ride : GPS coordinate {latitude,longitude}
	  */
	private double[] startPoint;
	
	/**
	 * destination point of the ride : GPS coordinate in form {latitude,longitude}
	 */
	private double[] destPoint;
	
	/**
	 * customer taking the ride
	 */
	private Customer cust;
	
	/**
	 * driver of the ride
	 */
	private Driver driver;
	
	/**
	 * car used for the ride
	 */
	private Cars car;
	
	/**
	 * state of the ride
	 */
	private String state;
	
	/**
	 * start date of the ride
	 */
	private GregorianCalendar startDate;
	
	/**
	 * end date of the ride
	 */
	private GregorianCalendar endDate;
	/**
	 * state of traffic during the ride
	 */
	private String traffic;
	
	/**
	 * list of rides
	 */
	public static ArrayList<Rides> rideList = new ArrayList<Rides>();

	// CONSTRUCTOR :
	/**
	 * create a ride
	 * @param startPoint : starting point of the ride
	 * @param destPoint : destination of the ride
	 * @param cust : customer taking the ride
	 * @param state : current state of the ride
	 */
	
	public Rides(double[] startPoint, double[] destPoint, Customer cust, String state, String traffic) {
		this.startPoint = startPoint;
		this.destPoint = destPoint;
		this.cust = cust;
		this.state = state;
		this.traffic = traffic;
		RidesFactory.incr += 1;
		rideList.add(this);
	}
	
	// OTHER METHODS :
	/**
	 * calculates the length of a ride
	 * @param startPoint : starting point of the ride
	 * @param destPoint : destination of the ride
	 * @return lgth : length of the ride in kilometers (as the crow flies)
	 */
	public static double length(double[] startPoint, double[] destPoint) {
		double lgth = Math.sqrt(Math.pow(destPoint[0]-startPoint[0],2)+Math.pow(destPoint[1]-startPoint[1],2));
		// Math.acos(Math.sin(x1)*Math.sin(x2)+Math.cos(x1)*Math.cos(x2)*Math.cos(y2-y1))*6371;
		return lgth;
	}
	
	/**
	 * calculates the basic rate
	 * @param length : length of the ride
	 * @param basicRates : list of basicRates in the form (l stands for length) {l<5km, 5<l<10, 10<l<20, l>20} 
	 * @return double basic rate corresponding to the given rates and length
	 */
	public static double basicRate(double length, double[] basicRates) {
		if(length < 5) {
			return(basicRates[0]);
		}
		else if(length < 10 ) { 
			return(basicRates[1]);
		}
		else if(length < 20) {
			return(basicRates[2]);
		}
		else { 
			return(basicRates[3]);
		}
	}
	
	/**
	 * calculates the traffic rate
	 * @param traffic : String giving the state of traffic ("low", "medium", or "heavy")
	 * @param trafficRates : traffic rates if traffic is : {"low","medium","heavy"}
	 * @return corresponding traffic rate
	 */
	public static double trafficRate(String traffic, double[] trafficRates ) {
		if(traffic.equalsIgnoreCase("low")) {
			return  trafficRates[0];
		}
		else if (traffic.equalsIgnoreCase("medium")) {
			return trafficRates[1];
		}
		else if(traffic.equalsIgnoreCase("heavy")) {
			return trafficRates[2];
		}
		else {
			return 0.0;
		}
	}
	
	public static double speed(String traffic) {
		if(traffic.equalsIgnoreCase("low")) {
			return  RidesFactory.averageSpeed[0];
		}
		else if (traffic.equalsIgnoreCase("medium")) {
			return RidesFactory.averageSpeed[1];
		}
		else if(traffic.equalsIgnoreCase("heavy")) {
			return RidesFactory.averageSpeed[2];
		}
		else {
			return 0.0;
		}
	}

	// GETTERS AND SETTERS :
	/**
	 * gets startPoint
	 * @return startPoint
	 */
	public double[] getStartPoint() {
		return startPoint;
	}
	/**
	 * set startPoint
	 * @param startPoint : new value of startPoint
	 */
	public void setStartPoint(double[] startPoint) {
		this.startPoint = startPoint;
	}
	/**
	 * get destPoint
	 * @return value of destPoint
	 */
	public double[] getDestPoint() {
		return destPoint;
	}
	/**
	 * set destPoint
	 * @param destPoint : new value of destPoint
	 */
	public void setDestPoint(double[] destPoint) {
		this.destPoint = destPoint;
	}
	/**
	 * get cust
	 * @return current value of customer
	 */
	public Customer getCust() {
		return cust;
	}
	/**
	 * set cust
	 * @param cust : new value of cust
	 */
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	/** get driver
	 * @return : driver of the ride
	 */
	public Driver getDriver() {
		return driver;
	}

	/**
	 * set driver
	 * @param driver : new driver of the ride
	 */
	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	/**
	 * get car
	 * @return : car of the ride
	 */
	public Cars getCar() {
		return car;
	}

	/**
	 * set car
	 * @param car : new car of the ride
	 */
	public void setCar(Cars car) {
		this.car = car;
	}

	/**
	 * get the state of the ride
	 * @return current state of the ride
	 */
	public String getState() {
		return state;
	}
	/** 
	 * set state of the ride
	 * @param state : new state of the ride
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * get startDate
	 * @return startDate : start date of the ride
	 */
	public GregorianCalendar getStartDate() {
		return startDate;
	}

	/**
	 * set startDate
	 * @param startDate : new start date of the ride
	 */
	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}

	/**
	 * get endDate
	 * @return endDate : end date of the ride
	 */
	public GregorianCalendar getEndDate() {
		return endDate;
	}

	/**
	 * set endDate
	 * @param endDate : new end date of the ride
	 */
	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}

	/**
	 * get traffic
	 * @return : traffic during the ride
	 */
	public String getTraffic() {
		return traffic;
	}

	/**
	 * set traffic
	 * @param traffic : new traffic during the ride
	 */
	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}
	
	// TO STRING METHODS:
	@Override
	public String toString() {
		return "[startPoint=" + Arrays.toString(startPoint) + ", destPoint=" + Arrays.toString(destPoint)
				+ ", cust=" + cust + ", driver=" + driver + ", car=" + car + ", state=" + state + ", startDate="
				+ startDate + ", endDate=" + endDate + ", traffic=" + traffic + "]";
	}
	
	/**
	 * display the current state of all rides
	 * @return : string with informations about the current state of all rides
	 */
	public static String displayRides() {
		String display = "List of rides : \n";
		for(Rides rides: rideList) {
			display+= rides.toString()+"\n";
		}
		if(rideList.size()==0) {
			display+="no ride for now";
		}
		return(display);
	}
}

