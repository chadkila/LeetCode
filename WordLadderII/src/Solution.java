import java.util.*;

/**
 *  leetcode word ladder II http://oj.leetcode.com/problems/word-ladder-ii/
 * 
 * Given two words (start and end), and a dictionary, find all shortest
 * transformation sequence(s) from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 * Return [ ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"] ]
 */

/**
 * @author yu
 * 
 */

class Node {
	int level;
	String val;
	LinkedList<Node> prevList;

	Node(int l, String str) {
		this.level = l;
		this.val = str;
	}

	/**
	 * The parents to the current node
	 * 
	 * @param node
	 */
	void addPrev(Node node) {
		if (prevList == null)
			prevList = new LinkedList<>();
		this.prevList.add(node);
	}
}

public class Solution {
	/*
	 * To store the words have been covered in BFS
	 */
	HashMap<String, Node> prevMap = new HashMap<>();
	/*
	 * The last node got by BFS
	 */
	Node endNode = null;

	ArrayList<ArrayList<String>> answer;

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
	 * To do DFS search from the bottom node.Because each word will be added to
	 * first index of the Array, so the Array's sequence is from top to bottom
	 * at last.
	 * 
	 * @param recur
	 *            recur stores each path from end to start
	 */
	void DFSAnswer(Node node, ArrayList<String> recur, String start) {
		if (node.val.equals(start)) {
			answer.add(recur);
			return;
		}
		ArrayList<String> temp;
		for (Node n : node.prevList) {
			temp = new ArrayList<String>(recur);
			temp.add(0, n.val);
			DFSAnswer(n, temp, start);
		}
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
	void BFS(Node node, String end, HashSet<String> dict, Queue<Node> queue) {

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
							adjNode.addPrev(parrentNode);
							// put this word into search history
							prevMap.put(adjNode.val, adjNode);
							// find the last word
							if (adjNode.val.equals(end)) {
								endNode = adjNode;
							} else {
								// it's children nodes will be searched next
								// layer
								queue.add(adjNode);
							}

						} else {
							// has got another parent and add this into parent
							// list if they are on the same layer
							if (prevMap.get(strB.toString()).level == parrentNode.level + 1) {
								prevMap.get(strB.toString()).addPrev(
										parrentNode);

							}
						}
					}
				}
			}
		}
	}

	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		// initializing start node
		Queue<Node> queue = new LinkedList<Node>();
		Node node = new Node(0, start);
		node.addPrev(null);
		prevMap.put(node.val, node);
		queue.add(node);
		// begin building the graph
		BFS(node, end, dict, queue);

		if (answer == null)
			answer = new ArrayList<ArrayList<String>>();
		if (endNode != null) {
			// to DFS the answer
			DFSAnswer(endNode, new ArrayList<String>(Arrays.asList(end)), start);
		}
		return answer;
	}
}
