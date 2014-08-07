import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 
 */

/**
 * @author yu
 * 
 */
public class SolutionTest {

	/**
	 * Test method for {@link Solution#anagrams(java.lang.String[])}.
	 */
	@Test
	public void testAnagrams() {
		String[] words = new String[] { "abc", "cba", "cab", "ncaa", "acna",
				"lalala" };
		Solution test = new Solution();
		System.out.print(test.anagrams(words));
	}
}
