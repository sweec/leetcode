package LinkedListCycle;

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode run1 = head, run2 = head;
        while (run2 != null && run2.next != null) {
        	run2 = run2.next;
        	if (run2 == run1)
        		return true;
        	run2 = run2.next;
        	if (run2 == run1)
        		return true;
        	run1 = run1.next;
        }
        return false;
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
