import java.util.*;

/**
 * http://oj.leetcode.com/problems/lru-cache/ 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. 
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 */

/**
 * @author yu
 * 
 */
public class LRUCache {
	private int capacity;
	int length;
	// head pointer (newer nodes)
	LinkedListNode head;
	// tail pointer (older nodes)
	LinkedListNode end;
	// hashtable stores keys and pointers to nodes
	private Hashtable<Integer, LinkedListNode> nodeTable;

	public LRUCache(int capacity) {
		nodeTable = new Hashtable<Integer, LinkedListNode>();
		this.capacity = capacity;
		this.length = 0;
	}

	// move the recent node to list head
	public int get(int key) {
		if (nodeTable.containsKey(key)) {
			LinkedListNode recent = nodeTable.get(key);
			remove(recent);
			setHead(recent);
			return recent.value;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		if (nodeTable.containsKey(key)) {
			// if the key already exists
			LinkedListNode recent = nodeTable.get(key);
			// set new value
			recent.value = value;
			// remove the node then add to head
			remove(recent);
			setHead(recent);
		} else {
			// add new key to head
			LinkedListNode recent = new LinkedListNode(key, value);
			if (length < capacity) {
				// has room for new key
				nodeTable.put(key, recent);
				setHead(recent);
				length++;
			} else {
				// list is full, remove tailing node
				nodeTable.remove(end.key);
				remove(end);
				setHead(recent);
				nodeTable.put(key, recent);
			}
		}
	}

	private void remove(LinkedListNode node) {
		LinkedListNode current = node;
		LinkedListNode pre = node.pre;
		LinkedListNode next = node.next;

		if (pre == null) {
			// if it is head node
			head = next;
			current.next = null;
		} else {
			// previous node points to next one
			pre.next = next;
			current.pre = null;
		}

		if (next == null) {
			// if it is tailing node
			end = pre;
			current.pre = null;
		} else {
			next.pre = pre;
			current.next = null;
		}
	}

	private void setHead(LinkedListNode node) {
		// add node to head of the list
		node.next = head;
		// no node in front of head node
		node.pre = null;
		// if linked list is not empty, set node in front of head pointer
		if (head != null) {
			head.pre = node;
		}
		// set head pointer
		head = node;
		// if there is only one head node in list
		if (end == null) {
			// tailing and head is the same
			end = node;
		}
	}

}

class LinkedListNode {
	public int key;
	public int value;
	public LinkedListNode pre;
	public LinkedListNode next;

	public LinkedListNode(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
