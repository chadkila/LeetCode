import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testMaxProfit() {
		int prices[] = { 9, 8, 7, 6, 5, 4 };
		Solution test = new Solution();
		System.out.print(test.maxProfit(prices));
	}

}
