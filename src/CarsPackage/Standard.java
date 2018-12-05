package CarsPackage;


import java.util.ArrayList;

import Project.Driver;

/**
 * class representing the type of car Standard
 * @author mariongobet
 */

public class Standard extends Cars {
	
	// CONSTRUCTOR :
	/**
	 * crate a Standard car
	 * @param owners : drivers of the car
	 * @param nbSeats : number of seats
	 * @param carID : ID of the car
	 * @param coordGPS : position of the car
	 */
	public Standard(ArrayList<Driver> owners, int nbSeats, String carID, double[] coordGPS) {
		super(owners, nbSeats, carID, coordGPS);
	}
	
}
