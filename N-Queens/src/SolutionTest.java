import java.util.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolveNQueens() {
		Solution test = new Solution();
		List<String[]> ans = test.solveNQueens(4);
		Iterator<String[]> itr = ans.iterator();
		while (itr.hasNext()) {
			for (String str : itr.next()) {
				System.out.println(str);
			}
			System.out.println();
		}
	}

}
