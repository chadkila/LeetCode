import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testExist() {
		Solution test = new Solution();
		char board[][] = { { 'a', 'b', 'c', 'c' }, { 's', 'f', 'c', 's' },
				{ 'a', 'd', 'e', 'e' } };
		String word1 = "abcced";
		String word2 = "abcb";
		System.out.println(test.exist(board, word1));
		System.out.println(test.exist(board, word2));
	}

}
