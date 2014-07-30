/**
 * https://oj.leetcode.com/problems/text-justification/
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * For example, 
 * words: ["This", "is", "an", "example", "of", "text", "justification."] 
 * L: 16.
 * 
 * Return the formatted lines as: 
 * [ 
 * "This    is    an", 
 * "example  of text",
 * "justification.  " 
 * ]
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public List<String> fullJustify(String[] words, int L) {
		ArrayList<String> answer = new ArrayList<String>();
		if (words == null || words.length == 0)
			return answer;
		// current length
		int currLen = 0;
		// the head of a new line
		int lastIndex = 0;
		for (int i = 0; i <= words.length; i++) {
			// check if the pool has exceeded the max length
			if (i == words.length
					|| currLen + words[i].length() + i - lastIndex > L) {
				StringBuilder strBdr = new StringBuilder();
				// the total length of spaces
				int spaceLen = L - currLen;
				// the number of space slots
				int spaceNum = i - lastIndex - 1;
				// if all words in one line or there is only one word
				if (i == words.length || spaceNum == 0) {
					for (int j = lastIndex; j < i; j++) {
						strBdr.append(words[j]);
						// don't handle end spaces
						if (j != i - 1)
							strBdr.append(' ');
					}
					// end spaces
					appendSpace(strBdr, L - strBdr.length());
				} else {
					int space = spaceLen / spaceNum;
					int extra = spaceLen % spaceNum;
					for (int j = lastIndex; j < i; j++) {
						strBdr.append(words[j]);
						// don't handle end spaces
						if (j != i - 1)
							// append an extra space for those slots at first
							// if there are extra spaces
							appendSpace(strBdr, space
									+ (j - lastIndex < extra ? 1 : 0));
					}
				}
				answer.add(strBdr.toString());
				// a new head
				lastIndex = i;
				// new line
				currLen = 0;
			}
			// adding next word into pool
			if (i < words.length)
				currLen += words[i].length();
		}
		return answer;
	}

	// append more than one spaces
	private void appendSpace(StringBuilder temp, int count) {
		for (int i = 0; i < count; i++)
			temp.append(' ');
	}
}
