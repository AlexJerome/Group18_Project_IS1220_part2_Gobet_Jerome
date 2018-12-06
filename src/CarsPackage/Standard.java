package CarsPackage;


import java.util.ArrayList;

import Project.ClientApp;
import Project.Driver;

/**
 * class representing the type of car Standard
 * @author mariongobet
 */

public class Standard extends Cars {
	protected static Integer incr =0 ;
	
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
	
	//METHOD :

	public static void setupCars(int n) {
		for(int i=0;i<n;i++) {
			incr+=1;
			ArrayList<Driver> owner = new ArrayList<Driver>();
			owner.add(new Driver("driver"+i+"name","driver"+i+"surname"));
			new Standard(owner,4,"Standard"+incr.toString(),ClientApp.randomcoord());
		}
	}
	//TOSTRING :
	@Override
	public String toString() {
		return "Standard Car :" + super.toString();
	}
}
