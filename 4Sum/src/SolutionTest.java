import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testFourSum() {
		Solution test = new Solution();
		int num[] = { 1, 0, -1, 0, -2, 2 };

		System.out.print(test.fourSum(num, 0));
	}

}
