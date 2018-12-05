package CarsPackage;


import java.util.ArrayList;

import Project.Driver;

/**
 * class which creates cars
 * @author mariongobet
 */

public abstract class CarsFactory {
	
	public abstract void createCar();
	
	/**
	 * create a car of a defined type
	 * @param carType : Berline or Standard or Van
	 * @param owners : car's drivers 
	 * @param coordGPS : current position of the car
	 * @return Cars : the car created (or null if the type of car is unknown)
	 */
	
	public static Cars createCar(String carType, ArrayList<Driver> owners, double[] coordGPS) {
		if(carType.equalsIgnoreCase("Standard")) {
			Standard.incr += 1;
			return new Standard(owners, 4, "Standard"+ Integer.toString(Standard.incr) , coordGPS);
		}
		if(carType.equalsIgnoreCase("Van")) {
			Van.incr += 1;
			return new Van(owners, 6, "Van"+ Integer.toString(Van.incr) , coordGPS);
		}
		if(carType.equalsIgnoreCase("Berline")) {
			Berline.incr += 1;
			return new Berline(owners, 4, "Berline"+ Integer.toString(Berline.incr) , coordGPS);
		}
		System.out.println("No car created (unknown type)");
		return null;
	}
}

