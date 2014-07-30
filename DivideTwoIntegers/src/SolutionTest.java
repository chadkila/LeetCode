import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testDivide() {
		Solution test = new Solution();
		System.out.println(test.divide(19, 3));
		Solution test2 = new Solution();
		System.out.println(test2.divide(-21, 3));
		System.out.println(test2.divide(-2147483648, 1));
	}

}
