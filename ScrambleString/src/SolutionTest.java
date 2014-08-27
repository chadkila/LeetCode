import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testIsScramble() {
		Solution test = new Solution();
		System.out.println(test.isScramble("rgtae", "great"));
		System.out.println(test.isScramble("rgtea", "great"));
		System.out.println(test.isScramble("raatg", "great"));
	}

}
