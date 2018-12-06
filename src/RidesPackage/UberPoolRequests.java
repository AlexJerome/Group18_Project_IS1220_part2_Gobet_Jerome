/**
 * 
 */
package RidesPackage;

import java.util.ArrayList;

import CarsPackage.Cars;
import CarsPackage.Standard;
import Project.Customer;
import Project.Driver;

/**
 * @author mariongobet
 * class which represents the pool Request (maximum 3 requests)
 */
public class UberPoolRequests {
	
	/**
	 * 
	 * @author mariongobet
	 * nested class which respresents an individual request
	 */
	static class Request {
		private Customer customer;
		private double[] startPoint;
		private double[] destPoint;
		public Request(Customer customer, double[] startPoint, double[] destPoint) {
			this.customer = customer;
			this.startPoint = startPoint;
			this.destPoint = destPoint;
		}
	}
	/**
	 * request 1
	 */
	private Request request1;
	/**
	 * request 2
	 */
	private Request request2;
	/**
	 * request 3
	 */
	private Request request3;
	/**
	 * number of request which arrived
	 */
	private int nbRequest;
	
	/**
	 * list with all the poolRequest
	 */
	public static ArrayList<UberPoolRequests> requestList= new ArrayList<UberPoolRequests>();
	
	/**
	 * Constructor
	 * @param request1
	 */
	public UberPoolRequests (Request request1) {
		this.request1 = request1;
		this.nbRequest=1;
	}
	
	/**
	 * from a customer request, add a request to an existing poolRequest if not full,
	 * or to a new poolRequest if all of the others are full
	 * @param customer
	 * @param startPoint
	 * @param destPoint
	 * @return the rank of the pool request in the array list (int i, int j between 0 and 2)
	 */
	public static int[] addRequest(Customer customer, double[] startPoint, double[] destPoint) {
		Request request = new Request(customer,startPoint,destPoint);
		int[] result = new int[] {0,0};
		if (requestList.size()==0) {
			UberPoolRequests u = new UberPoolRequests(request);
			requestList.add(u);
			return result;
		}
		else {
			int i = 0;
			while (i<requestList.size() && requestList.get(i).getNbRequest()==3) {
				i += 1;
			}
			if (i==requestList.size()) {
				UberPoolRequests u = new UberPoolRequests(request);
				requestList.add(u);
				result[0] = requestList.size()-1;
				result[1] = 0;
				return result;
			}
			else if (requestList.get(i).getNbRequest()==1) {
				requestList.get(i).request2 = request;
				requestList.get(i).setNbRequest(2);
				result[0] = i;
				result[1] = 1;
				return result;
				}
			else if (requestList.get(i).getNbRequest()==2) {
				requestList.get(i).request2 = request;
				requestList.get(i).setNbRequest(3);
				result[0] = i;
				result[1] = 2;
				return result;
			}
		}
		return result;
	}
	
	/**
	 * from a point c and a list of points, return the rank of the closest neighbor
	 * @param c
	 * @param neighbors
	 * @return rank of the closest neighbor
	 */
	public static int closestNeighbor(double[] c, ArrayList<double[]> neighbors) {
		int i = 0;
		double min = Rides.length(c,neighbors.get(i));
		int rank = 0;
		for (double [] n : neighbors) {
			double length = Rides.length(c,n);
			if (length < min) {
				rank = i;
				min = length;
			}
			i += 1;
		}
		return rank;
	}
	
	/**
	 * compute the minimal distance of the Pick Up Drop Off trajectory
	 * @param c
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param d1
	 * @param d2
	 * @param d3
	 * @return optimized distance
	 */
	public static double pickUpDropOff (double[] c, double[] p1, double[] p2, double[] p3, double[] d1, double[] d2, double[] d3) {
		double totalLength = 0;
		ArrayList<double[]> neighbors = new ArrayList<double[]>();
		neighbors.add(p1);
		neighbors.add(p2);
		neighbors.add(p3);
		while (neighbors.size()>0) {
			int k = closestNeighbor(c,neighbors);
			totalLength += Rides.length(c,neighbors.get(k));
			System.out.println("rank = "+(k+1)+"length ="+totalLength);
			c=neighbors.get(k);
			neighbors.remove(k);
		}
		neighbors.add(d1);
		neighbors.add(d2);
		neighbors.add(d3);
		while (neighbors.size()>0) {
			int k = closestNeighbor(c,neighbors);
			totalLength += Rides.length(c,neighbors.get(k));
			System.out.println("rank = "+(k+1)+"length ="+totalLength);
			c=neighbors.get(k);
			neighbors.remove(k);
		}	
		return totalLength;
	}

	/**
	 * from a full poolRequest (3 requests), find a driver and a car which are available and belongs to request,
	 * beginning with the closest car
	 * @param u
	 * @return driver, car
	 */
	public static Object[] fromRequestFindDriver(UberPoolRequests u) {
		double p1[] = u.getRequest1().startPoint;
		double d1[] = u.getRequest1().destPoint;
		double p2[] = u.getRequest2().startPoint;
		double d2[] = u.getRequest2().destPoint;
		double p3[] = u.getRequest3().startPoint;
		double d3[] = u.getRequest3().destPoint;
		double min = Float.POSITIVE_INFINITY;
		Standard carChosen = null;
		Driver driverChosen = null;
		for (Cars car : Cars.carList) {
			if (car instanceof Standard) {
				boolean driverAvailable = false;
				Driver driverOnDuty = null;
				for (Driver driver : car.getOwners()) {
					if (driver.getState().equals("onduty")) {
						driverAvailable = true;
						driverOnDuty = driver;
					}
				}
				if (driverAvailable) {
					double[] c = car.getCoordGPS();
					double cost = pickUpDropOff(c,p1,p2,p3,d1,d2,d3);
					if (cost<min) {
						min = cost;
						carChosen = (Standard) car;
						driverChosen = driverOnDuty;
					}
				}
			}
		}
		Object[] obj = {driverChosen,carChosen};
		return obj;
	}
	
	/**
	 * @return the request1
	 */
	public Request getRequest1() {
		return request1;
	}

	/**
	 * @param request1 the request1 to set
	 */
	public void setRequest1(Request request1) {
		this.request1 = request1;
	}

	/**
	 * @return the request2
	 */
	public Request getRequest2() {
		return request2;
	}

	/**
	 * @param request2 the request2 to set
	 */
	public void setRequest2(Request request2) {
		this.request2 = request2;
	}

	/**
	 * @return the request3
	 */
	public Request getRequest3() {
		return request3;
	}

	/**
	 * @param request3 the request3 to set
	 */
	public void setRequest3(Request request3) {
		this.request3 = request3;
	}

	/**
	 * @return the nbrequest
	 */
	public int getNbRequest() {
		return nbRequest;
	}

	/**
	 * @param nbrequest the nb request to set
	 */
	public void setNbRequest(int nbRequest) {
		this.nbRequest = nbRequest;
	}
}
