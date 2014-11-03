import java.util.Arrays;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testGenerateMatrix() {
		Solution test = new Solution();
		int matrix[][] = test.generateMatrix(4);
		for (int i = 0; i < 4; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

}
