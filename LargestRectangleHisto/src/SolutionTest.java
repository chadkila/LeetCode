import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testLargestRectangleArea() {
		Solution test = new Solution();
		int height[] = { 1, 4, 6, 3, 7, 5, 2 };
		System.out.println(test.largestRectangleArea(height));
	}

}
