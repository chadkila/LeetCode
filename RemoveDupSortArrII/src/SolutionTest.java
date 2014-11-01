import java.util.Arrays;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testRemoveDuplicates() {
		Solution test = new Solution();
		int A[] = { 1, 1, 2, 3, 3, 3, 4 };
		System.out.println(test.removeDuplicates(A) + ":" + Arrays.toString(A));
	}

}
