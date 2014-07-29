import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testWordBreak() {
		String s1 = new String("asasas");
		Set<String> d1 = new HashSet<String>();
		d1.addAll(Arrays.asList("as"));
		Solution so1 = new Solution();
		System.out.println(so1.wordBreak(s1, d1));

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
		System.out.println(so2.BREAK[0][s2.length()]);
	}

}
