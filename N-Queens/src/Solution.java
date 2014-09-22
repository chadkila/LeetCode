/**
 * https://oj.leetcode.com/problems/n-queens/
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * ANS
 * pos[i] stands for which on column is the queen on row i.
 * If pos[i]=pos[j], means that i and j are on same column,
 * if |i-j|=|pos[i]-pos[j]|, means that i and j are on same diagonal
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public List<String[]> solveNQueens(int n) {
		List<String[]> ans = new ArrayList<String[]>();
		// position of each queen on each line
		int pos[] = new int[n];
		Arrays.fill(pos, -1);
		helper(pos, 0, ans);
		return ans;
	}

	private void helper(int pos[], int row, List<String[]> ans) {
		int n = pos.length;
		if (n == row) {
			// a temporary char array to construct string
			char tmp[][] = new char[n][n];
			// queen locations
			String rows[] = new String[n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(tmp[i], '.');
				tmp[i][pos[i]] = 'Q';
				rows[i] = new String(tmp[i]);
			}
			ans.add(rows);
			return;
		}
		for (int col = 0; col < n; col++) {
			if (isValid(pos, row, col)) {
				pos[row] = col;
				// go to next line
				helper(pos, row + 1, ans);
				pos[row] = -1;
			}
		}
	}

	private boolean isValid(int pos[], int row, int col) {
		for (int i = 0; i < row; i++) {
			// judge whether on same column or diagonal
			if (pos[i] == col || Math.abs(row - i) == Math.abs(col - pos[i]))
				return false;
		}
		return true;
	}
}
