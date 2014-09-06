import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testIsPalindrome() {
		Solution test = new Solution();
		System.out.println(test.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(test.isPalindrome("race a car"));
		System.out.println(test.isPalindrome(""));
		System.out.println(test.isPalindrome(" "));
	}

}
