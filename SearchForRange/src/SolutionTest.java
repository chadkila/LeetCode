import java.util.Arrays;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSearchRange() {
		Solution test = new Solution();
		int A[] = { 5, 7, 7, 8, 9, 10 };
		System.out.println(Arrays.toString(test.searchRange(A, 8)));
		System.out.println(Arrays.toString(test.searchRange(A, 5)));
		System.out.println(Arrays.toString(test.searchRange(A, 11)));
	}

}
