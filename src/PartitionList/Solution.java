package PartitionList;

public class Solution {
	public ListNode partition(ListNode head, int x) {
		ListNode last = null;	// last node before 1st element >= x
		ListNode pre = null, cur = head;
		while (cur != null) {
			while (cur != null && cur.val >= x) {
				pre = cur;
				cur = cur.next;
			}
			if (cur == null)
				break;
			ListNode next = cur.next;
			if (last == null) {
				if (cur != head) {
					cur.next = head;
					pre.next = next;
					head = cur;
				}
			} else {
				if (cur != last.next) {
					cur.next = last.next;
					pre.next = next;
					last.next = cur;
				}
			}
			last = cur;
			cur = next;
		}
		return head;
	}
 
    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) {
    		val = x;
    		next = null;
    	}
    }
}
