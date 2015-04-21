package RemoveDuplicatesFromSortedListII;

import Utility.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = null, cur = head, next;
        while (cur != null) {
        	next = cur.next;
        	while (next != null && next.val == cur.val)
        		next = next.next;
        	if (next != cur.next) {
        		if (pre == null) {
        			head = next;
        		} else {
        			pre.next = next;
        		}
        	} else
        		pre = cur;
         	cur = next;
        }
        return head;
    }
}
