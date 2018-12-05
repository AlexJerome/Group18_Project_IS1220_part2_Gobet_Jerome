package CarsPackage;


import java.util.ArrayList;

import Project.Driver;

/**
 * class representing the type of car Berline
 * @author mariongobet
 */

public class Berline extends Cars {
	
	// CONSTRUCTOR :
	/**
	 * create a Berline car
	 * @param owners : drivers of the car
	 * @param nbSeats : number of seats
	 * @param carID : ID of the car
	 * @param coordGPS : position of the car
	 */
	public Berline(ArrayList<Driver> owners, int nbSeats, String carID, double[] coordGPS) {
		super(owners, nbSeats, carID, coordGPS);
	}
}

