/**
 * https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 * Use a int[char] (filled -1) hash array to store the indexes.
 * When finding a duplicated char, stores the current length and compare with max.
 * Then go back to the last index and scan again.
 */
import java.util.Arrays;

/**
 * @author yu
 * 
 */
public class Solution {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		// save the position of each char (acsii number as index in arr)
		int[] arr = new int[256];
		Arrays.fill(arr, -1);

		// track the length of the current being check substring
		int len = 0;
		// track the max length of all substrings
		int max = 1;
		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			// means this char does not appear previously
			if (arr[c] == -1) {
				// record the position of this char in the string
				arr[c] = i;
				len++;
				i++;
			} else {
				// means this char has already appeared previously
				for (int j = arr[c] + 1; j < i; j++)
					arr[s.charAt(j)] = -1;
				// move the new start of substring to the position after the
				// last appearance of this char
				i = arr[c] + 1;
				// set that this char has not appeared in the current substring
				arr[c] = -1;

				max = Math.max(max, len);
				len = 0;
			}

		}
		// Note that, at the end of the above while loop, the last checked
		// substring's length was not compared with max
		max = Math.max(max, len);
		return max;
	}
}