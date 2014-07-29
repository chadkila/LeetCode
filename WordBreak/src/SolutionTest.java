import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class SolutionTest {

	@Test
	public void testWordBreak() {
		String s1 = new String("aaaaaaaaaaa");
		Set<String> d1 = new HashSet<String>();
		d1.addAll(Arrays.asList("a"));
		String s2 = new String("catsanddog");
		Set<String> d2 = new HashSet<String>();
		d2.addAll(Arrays.asList("cat", "and", "dog", "cats", "sand"));
		Solution s = new Solution();
		assertEquals(s.wordBreak(s1, d1), true);
		assertEquals(s.wordBreak(s2, d2), true);
		// fail("Not yet implemented");
	}

	@Test
	public void testWordBreak2() {

		String s2 = new String(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab");
		Set<String> d2 = new HashSet<String>();
		d2.addAll(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa",
				"aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
		Solution so2 = new Solution();
		System.out.println(so2.wordBreak(s2, d2));
		//for(int i =0;i<so2.BREAK.length;i++)
		System.out.println(so2.BREAK[0][s2.length()-1]);
	}
}
