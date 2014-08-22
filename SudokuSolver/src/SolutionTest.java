import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolveSudoku() {
		char board[][] = { { '.', '.', '.', '.', '.', '9', '.', '4', '.' },
				{ '.', '6', '.', '.', '.', '1', '7', '.', '.' },
				{ '.', '.', '.', '7', '4', '.', '.', '.', '2' },
				{ '.', '9', '5', '6', '1', '.', '.', '.', '3' },
				{ '.', '7', '6', '.', '8', '.', '2', '1', '.' },
				{ '1', '.', '.', '.', '7', '5', '9', '6', '.' },
				{ '5', '.', '.', '.', '3', '6', '.', '.', '.' },
				{ '.', '.', '9', '1', '.', '.', '.', '5', '.' },
				{ '.', '8', '.', '5', '.', '.', '.', '.', '.' } };
		printBoard(board);
		Solution test = new Solution();
		test.solveSudoku(board);
		printBoard(board);
	}

	private void printBoard(char board[][]) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
}
