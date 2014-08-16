import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testLongestPalindrome() {
		Solution test = new Solution();
		System.out.println(test.longestPalindrome("abcccb"));
		System.out.println(test.longestPalindrome("aa"));
		System.out.println(test.longestPalindrome("ac"));
	}

}
