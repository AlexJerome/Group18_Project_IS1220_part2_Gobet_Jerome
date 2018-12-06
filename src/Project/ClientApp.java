package Project;

import CarsPackage.Berline;
import CarsPackage.Cars;
import CarsPackage.CarsFactory;
import CarsPackage.Standard;
import CarsPackage.Van;

import RidesPackage.UberPoolRequests;
import RidesPackage.UberVan;
import RidesPackage.UberX;
import RidesPackage.NoDriverAvailable;
import RidesPackage.Rides;
import RidesPackage.RidesFactory;
import RidesPackage.UberBlack;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
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
	public static void displayState() {
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
	

	public static String simRide (String customerID, double[] destination, GregorianCalendar time, String rideType, double driverMark) throws NoDriverAvailable, PositionOutOfBoundaries {
		Customer customer = null;
		for (Customer cust : Customer.customerList) {
			if (customerID.equals(cust.getCustID())) {
				customer = cust;
			}
		}
		// traffic
		String traffic = RidesFactory.stateOfTraffic(time.HOUR);
		// Create Ride
		Rides ride = RidesFactory.createRide(rideType, customer.getCoordGPS(), destination, customer, "unconfirmed", traffic);
		// Find Car and Driver
		Object[] obj = new Object[] {null,null}; 
		int num = 0; // useful to compute price just after
		if (rideType.equals("UberX")) {
			obj = UberX.findDriver();
			ride.setState("confirmed");
			num = 0;
		}
		else if (rideType.equals("UberBlack")) {
			obj = UberBlack.findDriver();
			ride.setState("confirmed");
			num = 1;
		}
		else if (rideType.equals("UberVan")) {
			obj = UberVan.findDriver();
			ride.setState("confirmed");
			num = 3;
		}
		if (rideType.equals("UberPool")) {
			int[] place = UberPoolRequests.addRequest(customer, customer.getCoordGPS(), destination);
			int i = place[0];
			int j = place[1];
			if (i == 0 || i==1) {
				String display = "Please wait a moment, we are looking for another customer to travel with you in this UberPool ride";
				return display;
			}
			else {
				obj = UberPoolRequests.fromRequestFindDriver(UberPoolRequests.requestList.get(i));
				ride.setState("confirmed");
			}
			num = 2;
		}
		Driver driver = (Driver) obj[0];
		Cars car = (Cars) obj[1];
		ride.setState("ongoing");
		// price
		double length = Rides.length(customer.getCoordGPS(),destination);
		double[] prices = RidesFactory.evaluatePrices(traffic,length);
		double price = prices[num];
		//times
		GregorianCalendar timeDeparture = time;
		GregorianCalendar timeArrival = time;
		int duration = (int) (Rides.length(customer.getCoordGPS(),destination)*Rides.speed(traffic)*3600);
		timeArrival.add(GregorianCalendar.SECOND,duration);
		// update Ride's features
		ride.setStartDate(timeDeparture);
		ride.setEndDate(timeArrival);
		RidesFactory.sumPrice += price;
		// update Driver's features
		setDriverStatus(driver.getName(),driver.getSurname(),"onaride");
		driver.setCountMoney(driver.getCountMoney()+price);
		driver.setCountRides(driver.getCountRides()+1);
		// update Customer's features
		customer.setCountPrice(customer.getCountPrice()+price);
		customer.setCountTimeSpent(customer.getCountTimeSpent()+duration);
		customer.setCountRides(customer.getCountRides()+1);
		moveCustomer(customerID,destination[0],destination[1]);
		// update Car's features
		moveCar(car.getCarID(),destination[0],destination[1]);
		// return
		driver.setAppreciation((driver.getAppreciation()*(driver.getCountRides()-1)+driverMark)/driver.getCountRides());
		ride.setState("completed");
		setDriverStatus(driver.getName(),driver.getSurname(),"onduty");
		String display = "The driver "+driver.getDriverID()+" drives the customer "+customerID+" with the car "+car.getCarID()+". The departure is at "+timeDeparture+" and the arrival at "+timeArrival+". The cost of the ride is "+price;		
		return(display);
	}
		
	
	public static String simRide_i (String customerID, double[] destination, GregorianCalendar time) throws PositionOutOfBoundaries, NoDriverAvailable {
		Scanner sc =  new Scanner(System.in);
		Customer customer = null;
		for (Customer cust : Customer.customerList) {
			if (customerID.equals(cust.getCustID())) {
				customer = cust;
			}
		}
		
		// output-step1
		System.out.println(ask4price(customerID, destination, time));
		
		// input-step2
		System.out.println("Which type of ride do you want ?");
		String rideType = sc.nextLine();
		
		// output-step3
		// traffic
		String traffic = RidesFactory.stateOfTraffic(time.HOUR);
		// Create Ride
		Rides ride = RidesFactory.createRide(rideType, customer.getCoordGPS(), destination, customer, "unconfirmed", traffic);
		// Find Car and Driver
		Object[] obj = new Object[] {null,null}; 
		int num = 0; // useful to compute price just after
		if (rideType.equals("UberX")) {
			obj = UberX.findDriver();
			ride.setState("confirmed");
			num = 0;
		}
		else if (rideType.equals("UberBlack")) {
			obj = UberBlack.findDriver();
			ride.setState("confirmed");
			num = 1;
		}
		else if (rideType.equals("UberVan")) {
			obj = UberVan.findDriver();
			ride.setState("confirmed");
			num = 3;
		}
		if (rideType.equals("UberPool")) {
			int[] place = UberPoolRequests.addRequest(customer, customer.getCoordGPS(), destination);
			int i = place[0];
			int j = place[1];
			if (i == 0 || i==1) {
				String display = "Please wait a moment, we are looking for another customer to travel with you in this UberPool ride";
				return display;
			}
			else {
				obj = UberPoolRequests.fromRequestFindDriver(UberPoolRequests.requestList.get(i));
				ride.setState("confirmed");
			}
			num = 2;
		}
		Driver driver = (Driver) obj[0];
		Cars car = (Cars) obj[1];
		ride.setState("ongoing");
		// price
		double length = Rides.length(customer.getCoordGPS(),destination);
		double[] prices = RidesFactory.evaluatePrices(traffic,length);
		double price = prices[num];
		//times
		GregorianCalendar timeDeparture = time;
		GregorianCalendar timeArrival = time;
		int duration = (int) (Rides.length(customer.getCoordGPS(),destination)*Rides.speed(traffic)*3600);
		timeArrival.add(GregorianCalendar.SECOND,duration);
		// update Ride's features
		ride.setStartDate(timeDeparture);
		ride.setEndDate(timeArrival);
		RidesFactory.sumPrice += price;
		// update Driver's features
		setDriverStatus(driver.getName(),driver.getSurname(),"onaride");
		driver.setCountMoney(driver.getCountMoney()+price);
		driver.setCountRides(driver.getCountRides()+1);
		// update Customer's features
		customer.setCountPrice(customer.getCountPrice()+price);
		customer.setCountTimeSpent(customer.getCountTimeSpent()+duration);
		customer.setCountRides(customer.getCountRides()+1);
		moveCustomer(customerID,destination[0],destination[1]);
		// update Car's features
		moveCar(car.getCarID(),destination[0],destination[1]);
		// end of the ride
		ride.setState("completed");
		System.out.println("The driver "+driver.getDriverID()+" drives the customer "+customerID+" with the car "+car.getCarID()+". The departure is at "+timeDeparture+" and the arrival at "+timeArrival+". The cost of the ride is "+price);	
		
		// input-step3
		System.out.println("Give a mark to evaluate the driver");
		double driverMark = sc.nextDouble();
		driver.setAppreciation((driver.getAppreciation()*(driver.getCountRides()-1)+driverMark)/driver.getCountRides());
		// final-output
		displayState();
		return("");
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
	
}

