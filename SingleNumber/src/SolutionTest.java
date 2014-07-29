import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSingleNumber() {
		Solution test = new Solution();
		int A[] = new int[] { 1, 2, 3, 4, 3, 2, 1 };
		assertEquals(4, test.singleNumber(A));
	}

}
