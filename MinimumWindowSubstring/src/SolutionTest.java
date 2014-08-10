import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testMinWindow() {
		Solution test = new Solution();
		System.out.println(test.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(test.minWindow("ebadbaccb", "abc"));
		System.out.println(test.minWindow("QWERTYUIOP", "ASD"));
	}

}
