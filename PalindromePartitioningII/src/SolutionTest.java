import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testMinCut() {
		Solution test = new Solution();
		System.out.println(test.minCut("ababbbabbaba"));
		System.out.println(test.minCut("aba"));
		System.out.println(test.minCut("ababababababababababababcbabababababababababababa"));
	}

}
