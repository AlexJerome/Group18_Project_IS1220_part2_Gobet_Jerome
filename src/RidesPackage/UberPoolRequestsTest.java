package RidesPackage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class UberPoolRequestsTest {

	/**
	 * test closest neighbors
	 */
	@Test
	void testClosestNeighbors() {
		double c[] = {0,0};
		double p1[] = {0,2};
		double p2[] = {0,3};
		double p3[] = {0,1};
		double p4[] = {0,4};
		ArrayList<double[]> neighbors = new ArrayList<double[]>();
		neighbors.add(p1);
		neighbors.add(p2);
		neighbors.add(p3);
		neighbors.add(p4);
		int rank = UberPoolRequests.closestNeighbor(c,neighbors);
		assertEquals(rank,2);
	}
	
	/**
	 * test distance of pick up drop off trajectory
	 */
	@Test
	void testPickUpDropOff() {
		double c[] = {0,0};
		double p1[] = {0,2};
		double p2[] = {0,3};
		double p3[] = {0,1};
		double d1[] = {0,6};
		double d2[] = {0,5};
		double d3[] = {0,4};
		double l = UberPoolRequests.pickUpDropOff(c,p1,p2,p3,d1,d2,d3);
		assertEquals(l,6.0);
	}

}
