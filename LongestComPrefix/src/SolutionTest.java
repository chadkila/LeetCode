import org.junit.Test;

public class SolutionTest {

	@Test
	public void testLongestCommonPrefix() {
		Solution test = new Solution();
		String strs[] = { "abcde", "abc", "abcdef", "abcd" };
		System.out.println(test.longestCommonPrefix(strs));
	}

}
