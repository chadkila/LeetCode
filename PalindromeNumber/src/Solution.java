/**
 * https://oj.leetcode.com/problems/palindrome-number/
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 * 
 * ANS:
 * Using dividing and modulo to get high digit and low digit, compare them.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		// high digit divider
		int high = 1;
		// low digit divider
		int low = 1;
		// length of integer
		int len = 1;
		// get length and high divider
		while (x / high >= 10) {
			high *= 10;
			len++;
		}
		for (int i = 0; i < len / 2; i++) {
			if (x / high % 10 != x / low % 10)
				return false;
			// lower one digit of high divider
			high /= 10;
			// move up one digit of low divider
			low *= 10;
		}
		return true;
	}
}
