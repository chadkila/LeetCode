import org.junit.Test;

public class SolutionTest {

	@Test
	public void testIsValid() {
		Solution test = new Solution();
		System.out.println(test.isValid("([)]"));
		System.out.println(test.isValid("{}[]()"));
	}

}
