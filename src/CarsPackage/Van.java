package CarsPackage;


import java.util.ArrayList;

import Project.ClientApp;
import Project.Driver;

/**
 * class representing the type of car Van
 * @author mariongobet
 */

public class Van extends Cars {
	private static Integer incr =0;
	
	// CONSTRUCTOR :
	/**
	 * create a new Van
	 * @param owners : drivers of the car
	 * @param nbSeats : number of seats
	 * @param carID : ID of the car
	 * @param coordGPS : position of the car
	 */
	public Van(ArrayList<Driver> owners, int nbSeats, String carID, double[] coordGPS) {
		super(owners, nbSeats, carID, coordGPS);
	}

	// METHODS :
	/**
	 * create n cars of type Van, with a new driver for each one
	 * @param n
	 */
	public static void setupCars(int n) {
		for(int i=0;i<n;i++) {
			incr+=1;
			ArrayList<Driver> owner = new ArrayList<Driver>();
			owner.add(new Driver("driver"+Driver.getIncr()+"name","driver"+Driver.getIncr()+"surname"));
			new Van(owner,6,"Van"+incr.toString(),ClientApp.randomcoord());
		}
	}

	//TO STRING :
	@Override
	public String toString() {
		return "Van Car :" +super.toString();
	}
}
