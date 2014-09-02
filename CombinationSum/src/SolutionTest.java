import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testCombinationSum() {
		int num[] = { 10, 1, 2, 7, 6, 1, 5 };
		Solution test = new Solution();
		System.out.print(test.combinationSum(num, 5));
	}

}
