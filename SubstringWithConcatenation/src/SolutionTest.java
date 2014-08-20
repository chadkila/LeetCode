import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testFindSubstring() {
		Solution test = new Solution();
		String str[] = { "foo", "bar" };
		System.out.println(test.findSubstring("barfoothefoobarman", str));
	}

}
