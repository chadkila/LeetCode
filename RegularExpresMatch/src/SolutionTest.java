import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testIsMatch() {
		Solution test = new Solution();
		System.out.println(test.isMatch("", "aa"));
		System.out.println(test.isMatch("aab", "c*a*b"));
		System.out.println(test.isMatch("abc", "a***bc"));
		System.out.println(test.isMatch("a", ".*..a*"));
		System.out.println(test.isMatch("aaa", "a*a"));
	}

}
