import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testReverseWords() {
		Solution s1 = new Solution();
		String t1 = new String(" leet code damn sucks  ");
		String t2 = new String("aaaaa ");
		String t3 = new String("   a   b ");
		String t4 = new String("a");
		System.out.println(s1.reverseWords(t1));
		System.out.println(s1.reverseWords(t2));
		System.out.println(s1.reverseWords(t3));
		System.out.println(s1.reverseWords(t4));
	}

}
