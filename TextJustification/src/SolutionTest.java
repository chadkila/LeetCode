import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testFullJustify() {
		Solution test = new Solution();
		String[] words = { "a", "bc", "efg", "hijk", "lmnopq" };
		System.out.print(test.fullJustify(words, 8));
		String[] words1 = { "a", "bc", "efg", "hijk", "lmnopq" };
		System.out.print(test.fullJustify(words1, 12));
		String[] words2 = { "a", "bc", "efg", "hijk", "lmnopq" };
		System.out.print(test.fullJustify(words2, 22));
		String[] words3 = { "" };
		System.out.print(test.fullJustify(words3, 2));
		String[] words4 = { "a", "b", "c", "d", "e" };
		System.out.print(test.fullJustify(words4, 3));
		String[] words5 = { "" };
		System.out.print(test.fullJustify(words5, 0));
	}

}
