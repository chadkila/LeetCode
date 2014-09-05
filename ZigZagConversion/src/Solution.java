/**
 * https://oj.leetcode.com/problems/zigzag-conversion/
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: 
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should
 * return "PAHNAPLSIIGYIR".
 * 
 * ANS
 * Every zigzag includes ZSize=2*nRows - 2 characters. (PAPY is a zigzag for 2*3-2)
 * For the first and last line, every character is separated by ZSize.
 * For the lines between them, the odd index character is ZSize-2*Lidx after the
 * previous one. (Lidx = line index)
 * 
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public String convert(String s, int nRows) {
		if (nRows < 2 || s.length() == 0)
			return s;
		int n = s.length();
		String ans = "";
		// get zigzag's size
		int ZSize = 2 * nRows - 2;
		// get result line by line
		for (int i = 0; i < nRows; i++) {
			// jump every zigzag size
			for (int j = i; j < n; j += ZSize) {
				ans += s.charAt(j);
				// if current line is not first or last line
				if (i > 0 && i < nRows - 1 && j + ZSize - 2 * i < n) {
					ans += s.charAt(j + ZSize - 2 * i);
				}
			}
		}
		return ans;
	}
}
