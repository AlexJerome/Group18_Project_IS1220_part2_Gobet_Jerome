package CarsPackage;


import java.util.ArrayList;

import Project.Driver;

/**
 * class representing the type of car Berline
 * @author mariongobet
 */

public class Berline extends Cars {
	protected static Integer incr =0;
	
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
	
	//coucoooooouuuuuuuuuu

	@Override
	void setupCars(int n) {
		for(int i=0;i<n;i++) {
			incr+=1;
			new Berline(new ArrayList<Driver>([new Driver("driver"+i+"name","driver"+i+"surname"])),4,"Standard"+incr.toString())
		}
	}
}

