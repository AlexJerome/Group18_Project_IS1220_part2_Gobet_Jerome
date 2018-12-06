package Project;

import java.util.Scanner;

import CarsPackage.Berline;
import CarsPackage.Cars;
import CarsPackage.CarsFactory;
import CarsPackage.Standard;
import CarsPackage.Van;

import java.util.ArrayList;
import java.util.Date;
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
	public static ArrayList<Customer> addCustomer(String customerName,String customerSurname) {
		new Customer(customerName,customerSurname,randomcoord(),48114548);
		return Customer.customerList;
	}
	//TODO : peut etre que le retour doit etre un print plutot qu'un return... ?
	/**
	 * creation of a driver and a car for this new driver
	 * @param driverName : driver name
	 * @param driverSurname : driver surname
	 * @param carType : typer of new car of the driver
	 * @return list of current drivers
	 */
	public static ArrayList<Driver> addCarDriver(String driverName,String driverSurname,String carType){
		ArrayList<Driver> owners = new ArrayList<Driver>();
		owners.add(new Driver(driverName,driverSurname));
		Cars car = CarsFactory.createCar(carType, owners, randomcoord());	
		return(Driver.driverList);
	}
	/**
	 * creation of a driver and add it to the list of drivers of a car with carID
	 * @param driverName : name of the driver
	 * @param driverSurname : surname of the driver
	 * @param carID : carID of the car
	 * @return curret list of cars
	 */
	public static ArrayList<Driver> addDriver(String driverName,String driverSurname,String carID) {
		Driver driver = new Driver(driverName,driverSurname);
		for(Cars car : Cars.CarList) {
			if(car.getCarID().contentEquals(carID)) {
				car.getOwners().add(driver);
			}
		}
		return(Driver.driverList);
	}
	
	public static ArrayList<Driver> setDriverStatus(String driverName, String driverSurname,String status){
		for(Driver driver)
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
		*/
		Date aujourdhui = new Date();
		System.out.println(aujourdhui.getHours());
		System.out.println(aujourdhui.getMinutes());
		System.out.println(aujourdhui.getSeconds());
		double duration = 4569;
		int hour = (int) (duration/3600);
		int min = (int)((duration-hour*3600)/60);
		int sec = (int)((duration-hour*3600-min*60));
		System.out.println(hour+" "+min+" "+sec);
	}
}

