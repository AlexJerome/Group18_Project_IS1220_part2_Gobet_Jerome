package CarsPackage;


import java.util.ArrayList;
import java.util.Arrays;

import Project.Driver;
/**
 * abstract class which is a template for all kind of cars (Standard, Berline, Van)
 * @author mariongobet
 */
public abstract class Cars {
	/**
	 * list of the car's drivers
	 */
	private ArrayList<Driver> owners;
	/**
	 * number of seats excluding driver
	 */
	private int nbSeats;
	/**
	 * ID of the car (in the form : "StandardN" or "VanN" or "BerlineN", where N is an unique id for each type of car)
	 */
	private String carID;
	/**
	 * position of the car in degrees (GPS coordinates {latitude,longitude})
	 */
	private double[] coordGPS;
	/**
	 * list of cars
	 */
	public static ArrayList<Cars> carList = new ArrayList<Cars>();
	
	// CONSTRUCTOR :
	/**
	 * create a car
	 * @param owners : list of the car's drivers
	 * @param nbSeats : number of seats in the car excluding driver
	 * @param carID : ID of the car
	 * @param coordGPS : position of the car
	 */
	public Cars(ArrayList<Driver> owners, int nbSeats, String carID, double[] coordGPS) {
		this.owners = owners;
		this.nbSeats = nbSeats;
		this.carID = carID;
		this.coordGPS = coordGPS;
		carList.add(this);
	}
	
	// GETTERS AND SETTERS :
	/**
	 * get owners
	 * @return owners : list of the car's drivers
	 */
	public ArrayList<Driver> getOwners() {
		return owners;
	}
	/**
	 * set owners
	 * @param owners : new list of the car's driver
	 */
	public void setOwners(ArrayList<Driver> owners) {
		this.owners = owners;
	}
	/**
	 * get NbSeats
	 * @return nbSeats : number of seats
	 */
	public int getNbSeats() {
		return nbSeats;
	}
	/**
	 * set NbSeats
	 * @param nbSeats : new number of seats
	 */
	public void setNbSeats(int nbSeats) {
		this.nbSeats = nbSeats;
	}
	/**
	 * get ID
	 * @return carID : ID of the car
	 */
	public String getCarID() {
		return carID;
	}
	/**
	 * get GPS coordinates
	 * @return coordGPS : position of the car
	 */
	public double[] getCoordGPS() {
		return coordGPS;
	}
	/**
	 * set GPS coordinates
	 * @param coordGPS : new position of the car
	 */
	public void setCoordGPS(double[] coordGPS) {
		this.coordGPS = coordGPS;
	}


	
	//TO STRING METHODS :

	/**
	 * display the state of one car
	 */
	@Override
	public String toString() {
		return " [owners=" + owners + ", nbSeats=" + nbSeats + ", carID=" + carID + ", coordGPS="
				+ Arrays.toString(coordGPS) + "]";
	}
	
	/**
	 * display state of all current cars
	 * @return : string with all information about the cars
	 */
	public static String displayCars() {
		String display = "List of cars : \n";
		for(Cars car: carList) {
			display += car.toString()+"\n";
		}
		return(display);
	}
}

