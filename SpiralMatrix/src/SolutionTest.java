import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSpiralOrder() {
		Solution test = new Solution();
		int[][] num = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] num1 = { { 1, 2, 3, 4, 5, 6 } };
		int[][] num2 = { { 1 } };
		System.out.print(test.spiralOrder(num));
		System.out.print(test.spiralOrder(num1));
		System.out.print(test.spiralOrder(num2));
	}

}
