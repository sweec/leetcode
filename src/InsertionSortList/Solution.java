package InsertionSortList;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
    	if (head == null)
    		return head;
        ListNode fh = new ListNode(0);
        fh.next = head;
        ListNode pre = head, cur = head.next;
        while (cur != null) {
        	if (cur.val >= pre.val) {
        		pre = cur;
        		cur = cur.next;
        	} else {
        		ListNode n = fh;
        		while (n.next.val < cur.val)
        			n = n.next;
        		pre.next = cur.next;
        		cur.next = n.next;
        		n.next = cur;
        		cur = pre.next;
        	}
        }
        return fh.next;
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
