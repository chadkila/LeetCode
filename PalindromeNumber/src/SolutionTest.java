import org.junit.Test;

public class SolutionTest {

	@Test
	public void testIsPalindrome() {
		Solution test = new Solution();
		System.out.println(test.isPalindrome(123454321));
		System.out.println(test.isPalindrome(-123454321));
		System.out.println(test.isPalindrome(12345431));
	}

}
