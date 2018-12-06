/**
 * 
 */
package RidesPackage;

import java.util.ArrayList;

/**
 * @author mariongobet
 *
 */
public class UberPoolRequests {
	
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
}
