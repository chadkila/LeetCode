import java.util.Arrays;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSetZeroes() {
		Solution test = new Solution();
		int matrix[][] = { { 1, 2, 0, 4 }, { 1, 0, 3, 4 }, { 1, 2, 3, 4 },
				{ 1, 2, 3, 4 } };
		test.setZeroes(matrix);
		System.out.println(Arrays.toString(matrix[0]));
		System.out.println(Arrays.toString(matrix[1]));
		System.out.println(Arrays.toString(matrix[2]));
		System.out.println(Arrays.toString(matrix[3]));
	}

}
