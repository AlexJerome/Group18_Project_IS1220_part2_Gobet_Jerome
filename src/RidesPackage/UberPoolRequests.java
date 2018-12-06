/**
 * 
 */
package RidesPackage;

import java.util.ArrayList;

import Project.Customer;

/**
 * @author mariongobet
 *
 */
public class UberPoolRequests {
	
	class Request {
		private Customer customer;
		private double[] startPoint;
		private double[] destPoint;
		public Request(Customer customer, double[] startPoint, double[] destPoint) {
			this.customer = customer;
			this.startPoint = startPoint;
			this.destPoint = destPoint;
		}
	}
	
	private Request request1;
	private Request request2;
	private Request request3;
	private int nbRequest;
	
	private ArrayList<UberPoolRequests> requestList= new ArrayList<UberPoolRequests>();
	
	public UberPoolRequests (Request request1) {
		this.request1 = request1;
		this.nbRequest=1;
	}
	
	public void addRequest(Request request) {
		if (requestList.size()==0) {
			UberPoolRequests u = new UberPoolRequests(request);
			requestList.add(u);
		}
		else {
			int i = 0;
			while (i<requestList.size() && requestList.get(i).getNbRequest()==3) {
				i += 1;
			}
			if (i==requestList.size()) {
				UberPoolRequests u = new UberPoolRequests(request);
				requestList.add(u);
			}
			else if (requestList.get(i).getNbRequest()==1) {
				requestList.get(i).request2 = request;
				requestList.get(i).setNbRequest(2);
				}
			else if (requestList.get(i).getNbRequest()==2) {
					requestList.get(i).request2 = request;
					requestList.get(i).setNbRequest(3);
			}
		}
	}
	
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

	/**
	 * @return the requestList
	 */
	public ArrayList<UberPoolRequests> getRequestList() {
		return requestList;
	}

	/**
	 * @param requestList the requestList to set
	 */
	public void setRequestList(ArrayList<UberPoolRequests> requestList) {
		this.requestList = requestList;
	}
}
