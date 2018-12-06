package testScenario;

import java.util.Calendar;
import java.util.GregorianCalendar;

import CarsPackage.Cars;
import Project.ClientApp;
import Project.Customer;
import Project.Driver;
import Project.PositionOutOfBoundaries;
import RidesPackage.NoDriverAvailable;
import RidesPackage.Rides;
import RidesPackage.RidesFactory;
import RidesPackage.UberBlack;

/*
 * test scenario:
 * setup of the environment
 * one customer wants to go somewhere
 * he asks for the prices
 * he chooses the type of ride UberBlack
 * an available driver takes the ride
 * the ride is finished and the customer gives an appreciation rate of 3.0
 * 
 */
public class TestScenario1 {

	public static void main(String[] args) throws NoDriverAvailable, PositionOutOfBoundaries {
		
		ClientApp.setup(3,3,3,6); //Creation of 10 cars of each car type
		System.out.println("State of the system before the test scenario \n");
		ClientApp.displayState();
		System.out.println("\n A customer Roger Dupont wants to book a ride : \n");
		Customer customer = new Customer("Roger","Dupont",ClientApp.randomcoord(),68734354);
		double[] destination = {58.0,45.0};
		
		GregorianCalendar timeDeparture = (GregorianCalendar) GregorianCalendar.getInstance();
		System.out.println("He asks for the prices of each type of ride for his give destination :");
		System.out.println(ClientApp.ask4price(customer.getCustID(), destination,(GregorianCalendar) GregorianCalendar.getInstance()));
		System.out.println("He chooses an UberBlack ride.");
		String stateTraffic = RidesFactory.stateOfTraffic(timeDeparture.HOUR);
		Rides ride = RidesFactory.createRide("UberBlack", customer.getCoordGPS(), destination, customer, "unconfirmed", stateTraffic);
		System.out.println("A ride is created :" + ride.toString());
		ClientApp.setDriverStatus("driver5name", "driver5surname", "onduty");
		Object[] obj = new Object[] {null,null}; 
		obj = UberBlack.findDriver();
		Driver driver = (Driver) obj[0];
		Cars car = (Cars) obj[1];
		System.out.println("A driver accepts the ride:"+driver.toString());
		GregorianCalendar timeArrival = timeDeparture;
		int duration = (int) (Rides.length(customer.getCoordGPS(),destination)*Rides.speed(stateTraffic)*3600);
		timeArrival.add(GregorianCalendar.SECOND,duration);
		
		// update Ride's features
		double length = Rides.length(customer.getCoordGPS(),destination);
		ride.setStartDate(timeDeparture);
		ride.setEndDate(timeArrival);
		double price = RidesFactory.evaluatePrices(stateTraffic,length)[1];
		RidesFactory.sumPrice += price;
		// update Driver's features
		ClientApp.setDriverStatus(driver.getName(),driver.getSurname(),"onaride");
		driver.setCountMoney(driver.getCountMoney()+price);
		driver.setCountRides(driver.getCountRides()+1);
		// update Customer's features
		customer.setCountPrice(customer.getCountPrice()+price);
		customer.setCountTimeSpent(customer.getCountTimeSpent()+duration);
		customer.setCountRides(customer.getCountRides()+1);
		ClientApp.moveCustomer(customer.getCustID(),destination[0],destination[1]);
		// update Car's features
		ClientApp.moveCar(car.getCarID(),destination[0],destination[1]);
		// return
		driver.setAppreciation((driver.getAppreciation()*(driver.getCountRides()-1)+3.0)/driver.getCountRides());
		ride.setState("completed");
		ClientApp.setDriverStatus(driver.getName(),driver.getSurname(),"onduty");
		String display = "The driver "+driver.getDriverID()+" drives the customer "+customer.getCustID()+" with the car "+car.getCarID()+". The cost of the ride is "+price;		
		
		System.out.println("The customer takes the ride and gives an appreciation rate of 3.0 out of 5. Here is a summary of the ride :");
		System.out.println(display);
		
		System.out.println("Here is the state of the system at the end of the test scenario :");
		ClientApp.displayState();
		
	}
}
