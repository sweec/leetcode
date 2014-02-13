package AddTwoNumbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if (l1 == null && l2 == null)
    		return null;
    	ListNode head = null, cur = null;
    	int extra = 0;
        while (l1 != null && l2 != null) {
        	int d = l1.val+l2.val+extra;
        	if (d >= 10) {
        		d -= 10;
        		extra = 1;
        	} else
        		extra = 0;
        	ListNode node = new ListNode(d);
        	if (cur == null) {
        		cur = node;
        		head = cur;
        	} else {
        		cur.next = node;
        		cur = node;
        	}
        	l1 = l1.next;
        	l2 = l2.next;
        }
        ListNode l = null;
        if (l1 != null)
        	l = l1;
        else if (l2 != null)
        	l = l2;
        while (l != null) {
        	int d = l.val + extra;
        	if (d >= 10) {
        		d -= 10;
        		extra = 1;
        	} else
        		extra = 0;
        	ListNode node = new ListNode(d);
        	if (cur == null) {
        		cur = node;
        		head = cur;
        	} else {
        		cur.next = node;
        		cur = node;
        	}
        	l = l.next;
        }
        if (extra == 1) {
        	ListNode node = new ListNode(1);
        	cur.next = node;
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
