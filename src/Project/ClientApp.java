package Project;

import java.util.Scanner;

import CarsPackage.Berline;
import CarsPackage.Cars;
import CarsPackage.CarsFactory;
import CarsPackage.Standard;
import CarsPackage.Van;

import RidesPackage.UberPoolRequests;
import RidesPackage.Rides;
import RidesPackage.RidesFactory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.time.LocalTime;

/**
 * @author mariongobet
 */

public class ClientApp {
	
	public void askARide() {
		
	}
	/**
	 * to create random coordinates between (0,0) and (100,100)
	 * @return random coordinates
	 */
	public static double[] randomcoord() {
		double coordX = Math.random()*100.0;
		double coordY = Math.random()*100.0;
		double[] coord = {coordX,coordY};
		return(coord);
	}
	
	/**
	 * create Standard Cars, Berline cars and Van cars
	 * @param nStandardCars nb of standard cars to create
	 * @param nBerlinCars nb of berlin cars to create
	 * @param nVanCars number of van cars to create
	 * @param nCustomers number of customer to create
	 */
	public static void setup( int nStandardCars, int nBerlinCars,int nVanCars,int nCustomers) {
		Standard.setupCars(nStandardCars);
		Berline.setupCars(nBerlinCars);
		Van.setupCars(nVanCars);
		Customer.setupCustomers(nCustomers);
	}
	/**
	 * creation of a customer
	 * @param customerName : name of the customer
	 * @param customerSurname : surname of the customer
	 * @return list of current customers
	 */
	public static String addCustomer(String customerName,String customerSurname) {
		new Customer(customerName,customerSurname,randomcoord(),48114548);
		return Customer.displayCustomers();
	}

	/**
	 * creation of a driver and a car for this new driver
	 * @param driverName : driver name
	 * @param driverSurname : driver surname
	 * @param carType : typer of new car of the driver
	 * @return list of current drivers and cars
	 */
	public static String addCarDriver(String driverName,String driverSurname,String carType){
		ArrayList<Driver> owners = new ArrayList<Driver>();
		owners.add(new Driver(driverName,driverSurname));
		CarsFactory.createCar(carType, owners, randomcoord());	
		return(Driver.displayDrivers() + Cars.displayCars());
	}
	/**
	 * creation of a driver and add it to the list of drivers of a car with carID
	 * @param driverName : name of the driver
	 * @param driverSurname : surname of the driver
	 * @param carID : carID of the car
	 * @return current list of cars and drivers
	 */
	public static String addDriver(String driverName,String driverSurname,String carID) {
		Driver driver = new Driver(driverName,driverSurname);
		for(Cars car : Cars.carList) {
			if(car.getCarID().contentEquals(carID)) {
				car.getOwners().add(driver);
			}
		}
		return(Driver.displayDrivers()+Cars.displayCars());
	}
	/**
	 * set the status of a driver with given surname and name to status
	 * @param driverName : name of the driver we want to modify the status
	 * @param driverSurname : surname of the driver we sant to modify the status
	 * @param status : new state of the driver
	 * @return list of drivers
	 */
	public static String setDriverStatus(String driverName, String driverSurname,String status){
		for(Driver driver: Driver.driverList) {
			if(driver.getName().equals(driverName) && driver.getSurname().contentEquals(driverSurname)) {
				String lastState = driver.getState();
				driver.setState(status);
				GregorianCalendar timeLastChange = driver.getDateChangeState();
				GregorianCalendar timenow = (GregorianCalendar) GregorianCalendar.getInstance();
				driver.setDateChangeState(timenow);
				long timeA = timeLastChange.getTimeInMillis();
				long timeB = timenow.getTimeInMillis();
				long time = timeB - timeA;
				switch(lastState) {
				case("offline"): driver.setTimeOffline(driver.getTimeOffline()+time); break;
				case("offduty") : driver.setTimeOffDuty(driver.getTimeOffDuty()+time); break;
				case("onduty") : driver.setTimeOnDuty(driver.getTimeOnDuty()+time); break;
				case("onaride") : driver.setTimeOnARide(driver.getTimeOnARide()+time); break;
				}
			}
		}
		return(Driver.displayDrivers());
	}
	
	/**
	 * move a car with given ID to the given position
	 * @param carID : carID of the car we want to move
	 * @param xPos : x coordinate of the new position of the car
	 * @param yPos : y coordinate of the new position of the car
	 * @return list of current cars
	 * @throws PositionOutOfBoundaries 
	 */
	public static String moveCar(String carID,double xPos,double yPos) throws PositionOutOfBoundaries{
		if(xPos>100.0 || xPos<0.0 || yPos>100.0 || yPos<0.0) {
			throw new PositionOutOfBoundaries("La voiture sort de la ville");
		}
		for(Cars car: Cars.carList) {
			if(car.getCarID().contentEquals(carID)) {
				double[] coord = {xPos,yPos};
				car.setCoordGPS(coord);
			}
		}
		return(Cars.displayCars());
	}
	/**
	 * move customer with given Id to a given place
	 * @param custID : id of the customer we want to move
	 * @param xPos : x value of the new position of the car
	 * @param yPos : y value of the new position of the car
	 * @return list of current customer
	 * @throws PositionOutOfBoundaries 
	 */
	public static String moveCustomer(String custID,double xPos,double yPos) throws PositionOutOfBoundaries{
		if(xPos>100.0 || xPos<0.0 || yPos>100.0 || yPos<0.0) {
			throw new PositionOutOfBoundaries("La voiture sort de la ville");
		}
		for(Customer cust: Customer.customerList) {
			if(cust.getCustID().contentEquals(custID)) {
				double[] coord = {xPos,yPos};
				cust.setCoordGPS(coord);
			}
		}
		return(Customer.displayCustomers());
	}
	
	/**
	 * display state of all the system
	 */
	public static void display() {
		System.out.println(Driver.displayDrivers());
		System.out.println(Customer.displayCustomers());
		System.out.println(Cars.displayCars());
		System.out.println(Rides.displayRides());
	}
	
	/**
	 * calculates the price of a given ride with different types of ride
	 * @param customerID : ID of the customer who asks for a ride
	 * @param destination : destination point wanted
	 * @param time : time of the ride
	 * @return a string which displays all the prices for all the kinds of rides
	 */
	public static String ask4price(String customerID, double[] destination,GregorianCalendar time) {
		String trafficState = RidesFactory.stateOfTraffic(time.get(Calendar.HOUR_OF_DAY));
		double[] startpoint = new double[2];
		for(Customer cust: Customer.customerList) {
			if(cust.getCustID().contentEquals(customerID)) {
				startpoint = cust.getCoordGPS();
			}
		}
		double length = Rides.length(startpoint,destination);
		double[] prices = RidesFactory.evaluatePrices(trafficState, length);
		String display = "List of prices :  \n UberX :"+prices[0]+", UberBlack :"+prices[1]+
				", UberPool :"+prices[2]+", UberVan :"+prices[3];
		return(display);
	}
	
	/**
	 * to display the drivers in the myUber system in increasing 
	 * order w.r.t. to the sorting policy 
	 * @param sortpolicy : either mostappreciated or most occuppied
	 */
	public static void displayDrivers(String sortpolicy) {
		switch(sortpolicy){
		case("mostappreciated") :{
			Stats.mostAppreciatedDriver();
			break;
		}
		case("mostoccupied") :{
			Stats.leastOccupiedDriver();
			break;
		}
		}
	}
	
	/**
	 *  to display the customers in the myUber system in increasing order w.r.t. to the sorting policy
	 * @param sortpolicy : either mostfrequent, or mostcharged
	 */
	public static void displayCustomers(String sortpolicy) {
		switch(sortpolicy) {
		case("mostfrequent"):{
			Stats.mostFrequentCustomer();
			break;
		}
		case("mostcharged"):{
			Stats.mostChargedCustomer();
			break;
		}
		}
	}
	
	/**
	 * total amount cashed by all drivers
	 * @return total amount
	 */
	public static double totalCashed() {
		return(Stats.totalAmountCharged());
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		
		// name
		System.out.println("Please enter your name :");
		String name = sc.nextLine();
		
		// surname
		System.out.println("Please enter your surname :");
		String surname = sc.nextLine();
		
		// startPoint
		System.out.println("Please enter your latitude in degrees :");
		double start_lat = sc.nextDouble();
		System.out.println("Please enter your longitude in degrees :");
		double start_lon = sc.nextDouble();
		double[] startPoint = new double[]{start_lat,start_lon};
		
		// creditCardNb
		System.out.println("Please enter your credit card number :");
		long creditCardNb = sc.nextLong();
		// construction of customer
		Customer cust = new Customer(name,surname,startPoint,creditCardNb);
		
		// destPoint
		System.out.println("Where do you want to go (latitude in degrees) ?");
		double dest_lat = sc.nextDouble();
		System.out.println("Where do you want to go (longitude in degrees) ?");
		double dest_lon = sc.nextDouble();
		double[] destPoint = new double[]{dest_lat,dest_lon};
		
		// length
		double length = Rides.length(startPoint, destPoint);
		System.out.println("The length of the ride is "+length+"km.");
		// TO DO : truncate length
		
		// computation of prices
		int hour = LocalTime.now().getHour();
		String traffic = RidesFactory.stateOfTraffic(hour);
		System.out.println("The traffic is "+traffic);
		double[] prices = RidesFactory.evaluatePrices(traffic,length);
		
		// calculation of prices
		// TO DO : truncate prices
		int standardIncr = CarsFactory.getStandardIncr();
		int berlineIncr = CarsFactory.getBerlineIncr();
		int vanIncr = CarsFactory.getVanIncr();
		if (standardIncr>0) {
			System.out.println("The price for an UberX ride is "+prices[0]+"€.");
			System.out.println("The price for an UberPool ride is "+prices[2]+"€.");
		}
			
		if (berlineIncr>0) {
			System.out.println("The price for an UberBlack ride is "+prices[1]+"€.");
		}
		if (vanIncr>0) {
			System.out.println("The price for an UberVan ride is "+prices[3]+"€.");
		}
		
		// choice of the ride
		System.out.println("Please choose the ride you prefer among those above :");
		String rideType = sc.nextLine();
		
		// construction of the ride
		RidesFactory.createRide(rideType,startPoint,destPoint,cust,"unconfirmed");
		
		// answer of the driver
		int N = 0;
		String typeCar = new String();
		if (rideType.equalsIgnoreCase("UberX")) {
			typeCar="Standard";
			N = standardIncr;
		}
		if (rideType.equalsIgnoreCase("UberPool")) {
			typeCar="Standard";
			N = standardIncr;
		}
		if (rideType.equalsIgnoreCase("UberBlack")) {
			typeCar="Berline";
			N = berlineIncr;
		}
		if (rideType.equalsIgnoreCase("UberVan")) {
			typeCar="Van";
			N = vanIncr;
		}
		/*
		boolean waiting = true;
		int i = 1;
		while (waiting && i<=N) {
			String ID=typeCar+Integer.toString(N);
			// Ask if a driver of the car named 'ID' is available
		}
		
		// TO BE COMPLETED
		
		sc.close();
		
		Driver driver = new Driver ("John","Johnny");
		System.out.println("His name is "+driver.getName()+", and his surname is "+driver.getSurname());
		
		Date aujourdhui = new Date();
		System.out.println(aujourdhui.getHours());
		System.out.println(aujourdhui.getMinutes());
		System.out.println(aujourdhui.getSeconds());
		double duration = 4569;
		int hour = (int) (duration/3600);
		int min = (int)((duration-hour*3600)/60);
		int sec = (int)((duration-hour*3600-min*60));
		System.out.println(hour+" "+min+" "+sec);
		*/

	}
}

