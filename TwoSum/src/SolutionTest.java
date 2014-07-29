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
	 * Test method for {@link Solution#twoSum(int[], int)}.
	 */
	@Test
	public void testTwoSum() {
		int numbers[] = new int[] { 0, 0, 0, 0 };
		int target = 0;
		Solution test = new Solution();
		System.out.print(test.twoSum(numbers, target)[0] + " "
				+ test.twoSum(numbers, target)[1]);
	}

}
