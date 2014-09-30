import java.util.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testMinimumTotal() {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		Solution test = new Solution();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));
		System.out.print(test.minimumTotal(triangle));
	}
}
