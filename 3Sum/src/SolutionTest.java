import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author yu
 * 
 */
public class SolutionTest {

	/**
	 * Test method for {@link Solution#threeSum(int[])}.
	 */
	@Test
	public void testThreeSum() {
		int numbers[] = new int[] { -1, 0, 1, 2, -1, -4 };
		Solution test = new Solution();
		System.out.println(test.threeSum(numbers));
	}

	@Test
	public void testThreeSum1() {
		int numbers[] = new int[] { 0, 0, 0, 0 };
		Solution test = new Solution();
		System.out.println(test.threeSum(numbers));
	}

	@Test
	public void testThreeSum2() {
		int numbers[] = new int[] { 1, -1, -1, 0 };
		Solution test = new Solution();
		System.out.println(test.threeSum(numbers));
	}
}
