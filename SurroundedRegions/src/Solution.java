import java.util.*;

/**
 * https://oj.leetcode.com/problems/surrounded-regions/
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by
 * 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * For example, 
 * X X X X 
 * X O O X 
 * X X O X 
 * X O X X 
 * 
 * After running your function, the
 * board should be:
 * 
 * X X X X 
 * X X X X 
 * X X X X 
 * X O X X
 * 
 */

/**
 * @author yu
 * 
 */
public class Solution {
	Queue<Integer> queue = new LinkedList<Integer>();
	int row;
	int col;

	/*
	 * find unsurrounded areas first then paint them to 'Y'
	 * then paint left 'O's to 'X'
	 */
	public void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;

		row = board.length;
		col = board[0].length;
		// start scanning at 4 edges of the board
		// if there is an 'O' then start BFS to search the region
		// up
		for (int i = 0; i < col; i++) {
			if (board[0][i] == 'O')
				BFS(board, 0, i);
		}
		// bottom
		for (int i = 0; i < col; i++) {
			if (board[row - 1][i] == 'O')
				BFS(board, row - 1, i);
		}
		// left
		for (int j = 0; j < row; j++) {
			if (board[j][0] == 'O')
				BFS(board, j, 0);
		}
		// right
		for (int j = 0; j < row; j++) {
			if (board[j][col - 1] == 'O')
				BFS(board, j, col - 1);
		}
		paintBoard(board);
	}

	void BFS(char[][] board, int m, int n) {
		int x;
		int y;
		check(board, m, n);
		while (!queue.isEmpty()) {
			int pos = queue.poll();
			x = pos / col;
			y = pos % col;
			// check neighbors
			check(board, x - 1, y);
			check(board, x + 1, y);
			check(board, x, y - 1);
			check(board, x, y + 1);
		}
	}

	/*
	 * if it is 'O', put it into queue and switch it to 'Y'
	 */
	void check(char[][] board, int x, int y) {
		if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] != 'O')
			return;
		queue.offer(x * col + y);
		board[x][y] = 'Y';
	}

	/*
	 * 'O' -> 'X'
	 * 'Y' -> 'O'
	 */
	void paintBoard(char[][] board) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				if (board[i][j] == 'Y')
					board[i][j] = 'O';
			}
		}
	}
}
