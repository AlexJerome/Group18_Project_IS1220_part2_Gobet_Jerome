package Project;

import java.util.ArrayList;
import java.util.Date;
/**
 * class representing drivers (people who can drive cars)
 * @author mariongobet
 */

public class Driver {
	/**
	 * name of the driver
	 */
	private String name;
	
	/**
	 * surname of the driver
	 */
	private String surname;
	
	/**
	 * ID of the driver (in the form : "Driver" where N is an unique id)
	 */
	private String driverID;
	
	/**
	 * state of the driver
	 */
	private String state;
	
	/**
	 * incrementation to give each driver a unique ID
	 */
	private static Integer incr = 0;
	
	/**
	 * amount cashed by the driver
	 */
	private int countMoney;
	
	/**
	 * appreciation of the driver (note)
	 */
	private double appreciation;
	
	/**
	 * time spent offline
	 */
	private double timeOffline;
	
	/**
	 * time spent on-duty
	 */
	private double timeOnDuty;
	
	/**
	 * time spent on-a-ride
	 */
	private double timeOnARide;
	
	/**
	 * time spent off-duty
	 */
	private double timeOffDuty;
	
	/**
	 * date of the last time that the Driver changed his state (for example from offline to on-duty)
	 */
	private Date dateChangeState;

	/**
	 * list of drivers 
	 */
	public static ArrayList<Driver> driverList = new ArrayList<Driver>();
	
	// CONSTRUCTOR :
	/**
	 * create a driver
	 * @param name : name of driver
	 * @param surname : surname of driver
	 */
	public Driver(String name, String surname) {
		super();
		incr += 1;
		this.name = name;
		this.surname = surname;
		this.driverID = "Driver" + Integer.toString(incr);
		this.state = "offline";
		driverList.add(this);
	}
	
	/**
	 * to create n Drivers
	 * @param nDrivers
	 */
	public static void setupDrivers(int nDrivers) {
		for(int i =0; i < nDrivers;i++) {
			new Driver("driver"+incr+"name","driver"+i+"surname");
		}
	}

	// GETTERS AND SETTERS :
	/**
	 * get name
	 * @return name : name of driver
	 */
	public String getName() {
		return name;
	}
	/**
	 * set name
	 * @param name : new name of the driver
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * get surname
	 * @return surname : surname of the driver
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * set surname
	 * @param surname : new surname of the driver
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * get ID
	 * @return driverID : ID of the driver
	 */
	public String getDriverID() {
		return driverID;
	}
	
	/**
	 * get state
	 * @return state : offline, on-duty, on-a-ride or off-duty
	 */
	public String getState() {
		return state;
	}
	/**
	 * set state
	 * @param state : new state (offline, on-duty, on-a-ride or off-duty)
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * get incr
	 * @return incr : number of drivers
	 */
	public static Integer getIncr() {
		return incr;
	}

	/**
	 * get countMoney
	 * @return countMoney : money cashed by the driver
	 */
	public int getCountMoney() {
		return countMoney;
	}

	/**
	 * set countMoney
	 * @param countMoney : new amount of money (generally increased)
	 */
	public void setCountMoney(int countMoney) {
		this.countMoney = countMoney;
	}

	/**
	 * get appreciation
	 * @return : appreciation of the driver
	 */
	public double getAppreciation() {
		return appreciation;
	}

	/**
	 * set appreciation
	 * @param : new appreciation of the driver (evolves after each ride)
	 */
	public void setAppreciation(double appreciation) {
		this.appreciation = appreciation;
	}

	/**
	 * get timeOffline
	 * @return timeOffline : time spent offline by the driver
	 */
	public double getTimeOffline() {
		return timeOffline;
	}

	/**
	 * set timeOffline
	 * @param timeOffline : new time spent offline (generally increased)
	 */
	public void setTimeOffline(double timeOffline) {
		this.timeOffline = timeOffline;
	}

	/**
	 * get timeOnDuty
	 * @return timeOnDuty : time spent on-duty by the driver
	 */
	public double getTimeOnDuty() {
		return timeOnDuty;
	}

	/**
	 * set timeOnDuty
	 * @param timeOnDuty : new time spent on-duty (generally increased)
	 */
	public void setTimeOnDuty(double timeOnDuty) {
		this.timeOnDuty = timeOnDuty;
	}

	/**
	 * get timeOnARide
	 * @return timeOnARide : time spent on-a-ride by the driver
	 */
	public double getTimeOnARide() {
		return timeOnARide;
	}

	/**
	 * set timeOnARide
	 * @param timeOnARide : new time spent on-a-ride (generally increased)
	 */
	public void setTimeOnARide(double timeOnARide) {
		this.timeOnARide = timeOnARide;
	}

	/**
	 * get timeOffDuty
	 * @return timeOffDuty : time spent off-duty by the driver
	 */
	public double getTimeOffDuty() {
		return timeOffDuty;
	}

	/**
	 * set timeOffDuty
	 * @param timeOffDuty : new time spent off-duty (generally increased)
	 */
	public void setTimeOffDuty(double timeOffDuty) {
		this.timeOffDuty = timeOffDuty;
	}

	/**
	 * get dateChangeState
	 * @return dateChangeState : date of the last change of the driver's state
	 */
	public Date getDateChangeState() {
		return dateChangeState;
	}

	/**
	 * set dateChangeState
	 * @param dateChangeState : new date of the change of the driver's state (generally modified with the actual date when the driver changes his state)
	 */
	public void setDateChangeState(Date dateChangeState) {
		this.dateChangeState = dateChangeState;
	}
}
