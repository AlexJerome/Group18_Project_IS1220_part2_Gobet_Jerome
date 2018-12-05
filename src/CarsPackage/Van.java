package CarsPackage;


import java.util.ArrayList;

import Project.Driver;

/**
 * class representing the type of car Van
 * @author mariongobet
 */

public class Van extends Cars {
	
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
	

}