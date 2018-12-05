package CarsPackage;


import java.util.ArrayList;

import Project.ClientApp;
import Project.Driver;

/**
 * class representing the type of car Van
 * @author mariongobet
 */

public class Van extends Cars {
	protected static Integer incr =0;
	
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
	public static void setupCars(int n) {
		for(int i=0;i<n;i++) {
			incr+=1;
			ArrayList<Driver> owner = new ArrayList<Driver>();
			owner.add(new Driver("driver"+i+"name","driver"+i+"surname"));
			new Van(owner,6,"Van"+incr.toString(),ClientApp.randomcoord());
		}
	}

}
