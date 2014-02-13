package RemoveDuplicatesFromSortedList;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head, next;
        while (cur != null) {
        	next = cur.next;
        	while (next != null && next.val == cur.val)
        		next = next.next;
        	cur.next = next;
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
