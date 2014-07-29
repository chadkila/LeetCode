import java.util.*;

/**
 * http://oj.leetcode.com/problems/word-ladder/ Given two words (start and end),
 * and a dictionary, find the length of shortest transformation sequence from
 * start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"] As
 * one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 */

class Node {
	int level;
	String val;

	Node(int l, String str) {
		this.level = l;
		this.val = str;
	}

}

/**
 * 
 * @author yu
 * 
 */
public class Solution {

	public Solution() {

	}

	/*
	 * To store the words have been covered in BFS
	 */
	HashMap<String, Node> prevMap = new HashMap<>();
	/*
	 * The last node got by BFS
	 */
	Node endNode = null;

	/**
	 * To judge whether the word is in dictionary or the end word
	 * 
	 * @return
	 */
	boolean IsInDict(HashSet<String> dict, String str, String end) {
		return dict.contains(str) || str.equals(end);
	}

	/**
	 * To identify whether the current word has been covered before
	 * 
	 * @return
	 */
	boolean IsInPrev(String str) {
		return prevMap.containsKey(str);
	}

	/**
	 * To do BFS search to generate the minimal path graph, which is only one
	 * top word and one bottom word.
	 * 
	 * @param node
	 *            the start node
	 * @param queue
	 *            controls which layer is searching
	 */
	int BFS(Node node, String end, HashSet<String> dict, Queue<Node> queue) {

		while (!queue.isEmpty()) {

			Node parrentNode = queue.remove();
			// Begin to start search the next layer
			for (int i = 0; i < node.val.length(); i++) {
				StringBuilder strB = new StringBuilder(parrentNode.val);
				for (char k = 'a'; k <= 'z'; k++) {
					strB.setCharAt(i, k);
					if (IsInDict(dict, strB.toString(), end)) {
						// this is a new word
						if (!IsInPrev(strB.toString())) {
							// initialize the new word
							Node adjNode = new Node(parrentNode.level + 1,
									strB.toString());
							// put this word into search history
							prevMap.put(adjNode.val, adjNode);
							// find the last word
							if (adjNode.val.equals(end)) {
								endNode = adjNode;
								// level start from 0, need to add 1
								return endNode.level + 1;
							} else {
								// it's children nodes will be searched next
								// layer
								queue.add(adjNode);
							}

						}
					}
				}
			}
		}
		return 0;
	}

	public int ladderLength(String start, String end, HashSet<String> dict) {
		// initializing start node
		Queue<Node> queue = new LinkedList<Node>();
		Node node = new Node(0, start);
		prevMap.put(node.val, node);
		queue.add(node);
		// begin building the graph
		return BFS(node, end, dict, queue);
	}
}
