package RidesPackage;


import java.util.ArrayList;
import java.util.Date;

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
	protected double[] startPoint;
	
	/**
	 * destination point of the ride : GPS coordinate in form {latitude,longitude}
	 */
	protected double[] destPoint;
	
	/**
	 * customer taking the ride
	 */
	protected Customer cust;
	
	/**
	 * driver of the ride
	 */
	protected Driver driver;
	
	/**
	 * car used for the ride
	 */
	protected Cars car;
	
	/**
	 * state of the ride
	 */
	protected String state;
	
	/**
	 * start date of the ride
	 */
	protected Date startDate;
	
	/**
	 * end date of the ride
	 */
	protected Date endDate;
	/**
	 * state of traffic during the ride
	 */
	protected String traffic;
	/**
	 * total number of rides
	 */
	private static int countAllRides = 0;
	
	/**
	 * total amount of charges
	 */
	private static double countAllPrices = 0.0;
	
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
	
	@SuppressWarnings("deprecation")
	public Rides(double[] startPoint, double[] destPoint, Customer cust, String state, String traffic) {
		this.startPoint = startPoint;
		this.destPoint = destPoint;
		this.cust = cust;
		this.state = state;
		this.traffic = traffic;
		/*
		this.startDate = new Date();
		//end date
		double duration = length(startPoint,destPoint)*speed(traffic)*3600;
		int hour = (int) (duration/3600);
		int min = (int)((duration-hour*3600)/60);
		int sec = (int)((duration-hour*3600-min*60));
		this.endDate=new Date();
		this.endDate.setHours(startDate.getHours()+hour);
		this.endDate.setMinutes(startDate.getMinutes()+min);
		this.endDate.setSeconds(startDate.getSeconds()+sec);
		*/
		countAllRides += 1;
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
		double x1 = Math.toRadians(startPoint[0]);
		double y1 = Math.toRadians(startPoint[1]);
		double x2 = Math.toRadians(destPoint[0]);
		double y2 = Math.toRadians(destPoint[1]);
		double lgth = Math.acos(Math.sin(x1)*Math.sin(x2)+Math.cos(x1)*Math.cos(x2)*Math.cos(y2-y1))*6371;
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
	 * get countAllRides
	 * @return countAllRides : total number of rides
	 */
	public static int getCountAllRides() {
		return countAllRides;
	}
	/**
	 * set countAllRides
	 * @param countRides : new number of rides
	 */
	public static void setCountAllRides(int countAllRides) {
		Rides.countAllRides = countAllRides;
	}
	/**
	 * get countAllPrices
	 * @return countAllPrices : total amount of charges
	 */
	public static double getCountAllPrices() {
		return countAllPrices;
	}
	/**
	 * set countAllPrices
	 * @param countAllPrices : new total amount of charges
	 */
	public static void setCountAllPrices(double countAllPrices) {
		Rides.countAllPrices = countAllPrices;
	}
}

