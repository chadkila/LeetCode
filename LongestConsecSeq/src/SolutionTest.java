import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testLongestConsecutive() {
		Solution test = new Solution();
		int num[] = { 100, 4, 200, 1, 3, 2 };
		System.out.println(test.longestConsecutive(num));
	}

}
