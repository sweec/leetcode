package MergeTwoSortedLists;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
        	return l2;
        if (l2 == null)
        	return l1;
        ListNode head = l1, pre = l1, cur = l1.next, alt = l2;
        if (l2.val < l1.val) {
        	head = l2;
        	pre = l2;
        	cur = l2.next;
        	alt = l1;
        }
        do {
        	while (cur != null && cur.val <= alt.val) {
        		pre = cur;
        		cur = cur.next;
        	}
        	if (cur == null) {
        		pre.next = alt;
        		break;
        	}
        	pre.next = alt;
        	alt = cur;
        	cur = pre.next.next;
        	pre = pre.next;
        } while (true);
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
