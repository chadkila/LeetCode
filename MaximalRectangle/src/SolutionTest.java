import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testMaximalRectangle() {
		char matrix[][] = { { '0', '0', '0', '0' }, { '0', '0', '0', '0' },
				{ '0', '1', '1', '0' }, { '0', '1', '0', '0' } };
		char matrix2[][] = {};
		Solution test = new Solution();
		System.out.println(test.maximalRectangle(matrix));
		System.out.println(test.maximalRectangle(matrix2));
	}

}
