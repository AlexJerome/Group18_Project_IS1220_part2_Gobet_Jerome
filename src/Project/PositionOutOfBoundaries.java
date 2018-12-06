package Project;

/**
 * exception for when a car or a customer is out of the boundaries (100,100)
 * @author alexandra
 *
 */
public class PositionOutOfBoundaries extends Exception {
	public PositionOutOfBoundaries(String message) {
		System.out.println(message);
	}

}
