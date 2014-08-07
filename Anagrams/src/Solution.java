import java.util.*;

/**
 * http://oj.leetcode.com/problems/anagrams/
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 */

/**
 * @author yu
 * 
 */
public class Solution {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		Hashtable<String, ArrayList<String>> wordTable = new Hashtable<String, ArrayList<String>>();
		String sorted = new String();
		for (int i = 0; i < strs.length; i++) {
			// sort every word first
			sorted = sortWord(strs[i]);
			ArrayList<String> values = wordTable.get(sorted);
			if (values != null) {
				// if the sorted word has appeared before
				values.add(strs[i]);
			} else {
				// if the sorted appears first time
				values = new ArrayList<String>();
				values.add(strs[i]);
				// put the sorted as key and original as value
				wordTable.put(sorted, values);
			}
		}

		// use Iterator to iterate through the hashtable
		for (Iterator iterator = wordTable.values().iterator(); iterator
				.hasNext();) {
			ArrayList<String> anagram = (ArrayList<String>) iterator.next();
			if (anagram.size() > 1) {
				result.addAll(anagram);
			}
		}
		return result;
	}

	private String sortWord(String w) {
		char[] charArray = w.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
}
