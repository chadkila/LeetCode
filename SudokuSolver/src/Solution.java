/**
 * https://oj.leetcode.com/problems/sudoku-solver/
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution.
 * 
 * It's a DFS problem again, if it finds an invalid path it will be popped
 * from stack and change the character back to '.'
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public void solveSudoku(char[][] board) {
		if (board.length != 9 || board[0].length != 9)
			return;
		DFS(board, 0, 0);
	}

	private boolean DFS(char[][] board, int i, int j) {
		// reached end of a row, return next row
		if (j == 9)
			return DFS(board, i + 1, 0);
		// reached end of the board, return true
		if (i == 9)
			return true;
		if (board[i][j] == '.') {
			// try all 9 numbers
			for (int n = 1; n <= 9; n++) {
				board[i][j] = (char) (n + '0');
				if (isValid(board, i, j)) {
					// if there would be a valid solution
					if (DFS(board, i, j + 1))
						return true;
				}
				// traced back from a failed path, set value back
				board[i][j] = '.';
			}
		} else {
			return DFS(board, i, j + 1);
		}
		// couldn't find a valid number
		return false;
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
