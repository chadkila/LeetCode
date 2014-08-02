import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testMaxProfit() {
		int prices[] = new int[] { 3, 9, 5, 2, 1, 4 };
		Solution test = new Solution();
		System.out.println(test.maxProfit(prices));
	}

	@Test
	public void testMaxProfit1() {
		int prices[] = new int[] { 2, 1 };
		Solution test = new Solution();
		System.out.println(test.maxProfit(prices));
	}

	@Test
	public void testMaxProfit3() {
		int prices[] = new int[] { 2 };
		Solution test = new Solution();
		System.out.println(test.maxProfit(prices));
	}

}
