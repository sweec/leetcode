package LRUCache;

import java.util.HashMap;

public class LRUCache {
	private ListNode head, tail;
	private int capacity, count;
	HashMap<Integer, ListNode> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        head = new ListNode(0, -1);
        tail = null;
        map = new HashMap<Integer, ListNode>();
    }
    
    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null)
        	return -1;
        else {
        	int value = node.next.value;
        	if (node != head) {
        		ListNode pre = node;
        		node = node.next;
        		pre.next = node.next;
        		if (pre.next != null)
        			map.put(pre.next.key, pre);
        		node.next = head.next;
        		map.put(node.next.key, node);
        		head.next = node;
        		map.put(key, head);
        		
        		if (tail == node)
        			tail = pre;
        	}
        	return value;
        }
    }
    
    public void set(int key, int value) {
    	if (capacity < 1)
    		return;
        ListNode node = map.get(key);
        if (node == null) {
        	if (count < capacity) {
        		node = new ListNode(key, value);
        		node.next = head.next;
        		head.next = node;
        		count++;
        		map.put(key, head);
        		if (count == 1)
        			tail = node;
        		else
        			map.put(node.next.key, node);
        	} else {
        		ListNode pre = map.get(tail.key);
        		map.remove(tail.key);
        		tail.key = key;
        		tail.value = value;
        		map.put(key, head);
        		if (capacity > 1) {
        			tail.next = head.next;
        			map.put(tail.next.key, tail);
        			head.next = tail;
        			pre.next = null;
        			tail = pre;
        		}
        	}
        } else {
        	node.next.value = value;
        	if (node != head) {
        		ListNode pre = node;
        		node = node.next;
        		pre.next = node.next;
        		if (pre.next != null)
        			map.put(pre.next.key, pre);
        		node.next = head.next;
        		map.put(node.next.key, node);
        		head.next = node;
        		map.put(key, head);
        		
        		if (tail == node)
        			tail = pre;
        	}
        }
    }
    
    private class ListNode {
    	int key, value;
    	ListNode next;
    	
    	public ListNode(int k, int v) {
    		key = k;
    		value = v;
    		next = null;
    	}
    }
}