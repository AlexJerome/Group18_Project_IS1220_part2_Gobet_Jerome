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
	 * number of Standard cars
	 */
	protected static Integer standardIncr = 0;
	/**
	 * number of Berline cars
	 */
	protected static Integer berlineIncr = 0;
	/** 
	 * number of Vans
	 */
	protected static Integer vanIncr = 0;
	
	/**
	 * create a car of a defined type
	 * @param carType : Berline or Standard or Van
	 * @param owners : car's drivers 
	 * @param coordGPS : current position of the car
	 * @return Cars : the car created (or null if the type of car is unknown)
	 */
	
	public static Cars createCar(String carType, ArrayList<Driver> owners, double[] coordGPS) {
		if(carType.equalsIgnoreCase("Standard")) {
			standardIncr += 1;
			return new Standard(owners, 4, "Standard"+ Integer.toString(standardIncr) , coordGPS);
		}
		if(carType.equalsIgnoreCase("Van")) {
			vanIncr += 1;
			return new Van(owners, 6, "Van"+ Integer.toString(vanIncr) , coordGPS);
		}
		if(carType.equalsIgnoreCase("Berline")) {
			berlineIncr += 1;
			return new Berline(owners, 4, "Berline"+ Integer.toString(berlineIncr) , coordGPS);
		}
		System.out.println("No car created (unknown type)");
		return null;
	}
	
	
	// GETTERS AND SETTERS
	/*
	/**
	 * get standardIncr
	 * @return standardIncr : number of Standard cars
	 */
	public static Integer getStandardIncr() {
		return standardIncr;
	}
	/**
	 * set standardIncr
	 * @param standardIncr : new number of Standard cars
	 */
	public static void setStandardIncr(Integer standardIncr) {
		CarsFactory.standardIncr = standardIncr;
	}
	/**
	 * get berlineIncr
	 * @return berlineIncr : number of Berline cars
	*/
	public static Integer getBerlineIncr() {
		return berlineIncr;
	}
	/**
	 * set berlineIncr
	 * @param berlineIncr : new number of Berline cars
	 */
	public static void setBerlineIncr(Integer berlineIncr) {
		CarsFactory.berlineIncr = berlineIncr;
	}
	/**
	 * get vanIncr
	 * @return vanIncr : number of Van cars
	 */
	public static Integer getVanIncr() {
		return vanIncr;
	}
	/**
	 * set vanIncr
	 * @param vanIncr : new number of Van Cars
	 */
	public static void setVanIncr(Integer vanIncr) {
		CarsFactory.vanIncr = vanIncr;
	}
}

