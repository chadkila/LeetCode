/**
 * https://oj.leetcode.com/problems/word-search/
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * [ 
 * ["ABCE"], 
 * ["SFCS"], 
 * ["ADEE"] 
 * ] 
 * word = "ABCCED", -> returns true, 
 * word = "SEE", -> returns true, 
 * word = "ABCB", -> returns false.
 * 
 * It's a DFS still, because may not use each cell more than once,
 * a array to track visited is needed
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public boolean exist(char[][] board, String word) {
		// 2-d array same size with board
		boolean visited[][] = new boolean[board.length][board[0].length];
		if (word.isEmpty() || word.length() == 0)
			return true;
		if (board.length == 0 || board[0].length == 0)
			return false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				// begin DFS
				if (DFS(board, word, 0, i, j, visited))
					return true;
			}
		}
		return false;
	}

	private boolean DFS(char[][] board, String word, int index, int i, int j,
			boolean visited[][]) {
		// searched to last character
		if (index == word.length())
			return true;
		// exceeding boarder, not found
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
			return false;
		// not the right path
		if (visited[i][j] || board[i][j] != word.charAt(index))
			return false;
		// visiting this cell
		visited[i][j] = true;
		boolean recur = DFS(board, word, index + 1, i - 1, j, visited)
				|| DFS(board, word, index + 1, i + 1, j, visited)
				|| DFS(board, word, index + 1, i, j - 1, visited)
				|| DFS(board, word, index + 1, i, j + 1, visited);
		// after popped up from stack, set the incorrect path to unvisited
		visited[i][j] = false;
		return recur;
	}
}
