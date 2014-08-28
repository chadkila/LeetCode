/**
 * https://oj.leetcode.com/problems/clone-graph/
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 * 
 * 
 * OJ's undirected graph serialization: Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label
 * and each neighbor of the node. As an example, consider the serialized graph
 * {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as
 * separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2. Second node
 * is labeled as 1. Connect node 1 to node 2. Third node is labeled as 2.
 * Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * 
 * ANS
 * could use DFS for graph traversal, and use a hashmap to store visited nodes
 */
import java.util.*;

/**
 * @author yu
 * 
 */
public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		HashMap<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		// root visited
		visited.put(node, copy);
		DFS(node, visited);
		return copy;
	}

	private void DFS(UndirectedGraphNode node,
			HashMap<UndirectedGraphNode, UndirectedGraphNode> visited) {
		for (int i = 0; i < node.neighbors.size(); i++) {
			UndirectedGraphNode cur = node.neighbors.get(i);
			if (!visited.containsKey(cur)) {
				UndirectedGraphNode copy = new UndirectedGraphNode(cur.label);
				visited.put(cur, copy);
				DFS(cur, visited);
			}
			// adding into neighbors list
			visited.get(node).neighbors.add(visited.get(cur));
		}
	}
}
