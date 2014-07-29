import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSingleNumber() {
		Solution test = new Solution();
		int A[] = new int[] { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4 };
		assertEquals(4, test.singleNumber(A));
	}

}
