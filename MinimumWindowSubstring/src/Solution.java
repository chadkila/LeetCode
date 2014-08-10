/**
 * https://oj.leetcode.com/problems/minimum-window-substring/
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * two pointers scan from left to right
 * e.g S = "ebadbaccb"，T = "abc"
 * start=idx=0
 * idx move to left until S[start,idx] covers all T's characters, idx = 6
 * start+=1 if S[start] is not in T or S[start+1,idx] still covers T, then start = 4
 * 6-4+1=3 the first window we get
 * start+=1, continue moving idx, idx = 8
 * continue moving start, start = 5, 8-5+1=4 > 3
 * window is [4,6]
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public String minWindow(String S, String T) {
		// ascii z is 122
		int THash[] = new int[123];
		// pointers for scanning
		int start = 0, idx = 0;
		// stores last found interval
		int begin = -1, end = S.length();
		// stores characters scanned from S
		int SHash[] = new int[123];
		// minimal window length
		int minLen = Integer.MAX_VALUE;
		// counter for characters found in S
		int count = 0;
		// initialize T character table
		for (int i = 0; i < T.length(); i++)
			THash[T.charAt(i)]++;
		// begin scanning
		while (idx < S.length()) {
			// find a character from T in S
			if (THash[S.charAt(idx)] != 0) {
				SHash[S.charAt(idx)]++;
				if (SHash[S.charAt(idx)] <= THash[S.charAt(idx)])
					count++;
				// T has been covered
				if (count == T.length()) {
					// move start pointer
					while (start < idx) {
						// --SHash means move start to next one and check
						// whether it affects counter, if not then current
						// window still covers T
						if (THash[S.charAt(start)] == 0
								|| --SHash[S.charAt(start)] >= THash[S
										.charAt(start)]) {
							start++;
						} else {
							// [start,idx] cannot cover T
							break;
						}
					}
					if (idx - start + 1 < minLen) {
						minLen = idx - start + 1;
						begin = start;
						end = idx;
					}
					// in that while(start<idx) loop start will finally moved to
					// a covered T's character and count and pointer were not
					// changed in that loop
					count--;
					start++;
				}
			}
			idx++;
		}
		return begin == -1 ? "" : S.substring(begin, end + 1);
	}
}
