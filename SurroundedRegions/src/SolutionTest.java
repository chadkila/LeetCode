import static org.junit.Assert.*;

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
	 * "XOXOXO","OXOXOX","XOXOXO","OXOXOX" Test method for
	 * {@link Solution#solve(char[][])}.
	 */
	@Test
	public void testSolve() {
		char[][] board = new char[][] { { 'X', 'O', 'X', 'O', 'X', 'O' },
				{ 'O', 'X', 'O', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'O', 'X', 'O' },
				{ 'O', 'X', 'O', 'X', 'O', 'X' } };
		Solution test = new Solution();
		test.solve(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}
}
