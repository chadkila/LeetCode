import org.junit.Test;

public class SolutionTest {

	@Test
	public void testCanCompleteCircuit() {
		Solution test = new Solution();
		int gas[] = { 3, 5, 8, 11, 13 };
		int cost[] = { 3, 6, 7, 11, 13 };
		System.out.println(test.canCompleteCircuit(gas, cost));
	}

}
