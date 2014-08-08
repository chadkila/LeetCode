import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testIsInterleave() {
		Solution test = new Solution();
		System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
		System.out.println(test.isInterleave("", "", ""));
	}

}
