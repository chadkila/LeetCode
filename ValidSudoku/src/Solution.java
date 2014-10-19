/**
 * https://oj.leetcode.com/problems/valid-sudoku/
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * A partially filled sudoku which is valid.
 * 
 * Note: A valid Sudoku board (partially filled) is not necessarily solvable.
 * Only the filled cells need to be validated.
 * 
 * ANS
 * As the problem mentioned, the board is not necessarily solvable, so we only 
 * need to check each number is valid.
 */

/**
 * @author yu
 * 
 */
public class Solution {

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.') {
					if (!isValid(board, i, j))
						return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, int i, int j) {
		// for the same row
		for (int j1 = 0; j1 < 9; j1++) {
			if (j1 != j && board[i][j] == board[i][j1])
				return false;
		}
		// for the same column
		for (int i1 = 0; i1 < 9; i1++) {
			if (i1 != i && board[i][j] == board[i1][j])
				return false;
		}
		// for the same block
		// (i/3)*3 is the first row, (j/3)*3 is the first column in block
		for (int i1 = i / 3 * 3; i1 < i / 3 * 3 + 3; i1++) {
			for (int j1 = j / 3 * 3; j1 < j / 3 * 3 + 3; j1++) {
				if ((i1 != i || j1 != j) && board[i][j] == board[i1][j1])
					return false;
			}
		}
		return true;
	}
}
