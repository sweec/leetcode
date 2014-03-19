package SortList;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
        	return head;
        ListNode fh = new ListNode(0);
        fh.next = head;
        int step = 1;
        do {
        	ListNode pre = fh, h1 = pre.next, h2 = h1;
        	int count = 0;
        	do {
        		count++;
        		int s = 1;
        		while (s < step && h2.next != null) {
        			h2 = h2.next;
        			s++;
        		}
        		if (h2.next == null)
        			break;
        		ListNode tail = h2;
        		h2 = tail.next;
        		tail.next = null;
        		int s1 = 0, s2 = 0;
        		do {
        			if (h1.val < h2.val) {
        				pre.next = h1;
        				while (s1 < step && h1.val <= h2.val) {
        					pre = h1; h1 = h1.next; s1++;
        				}
        				if (s1 == step) {
        					pre.next = h2; s2++;
        					while (s2 < step && h2.next != null) {
        						h2 = h2.next; s2++;
        					}
        					pre = h2; h2 = h2.next;
        					break;
        				}
        			} else {
        				pre.next = h2;
        				while (h2 != null && h2.val <= h1.val && s2 < step) {
        					pre = h2; h2 = h2.next; s2++;
        				}
        				if (s2 == step || h2 == null) {
        					pre.next = h1;
        					pre = tail;
        					pre.next = h2;
        					break;
        				}
        			}
        		} while (true);
        		if (h2 == null)
        			break;
        		h1 = h2;
        	} while (true);
        	if (count < 2)
        		break;
        	step *= 2;
        } while (true);
        return fh.next;
    }

    class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) {
    		val = x;
    		next = null;
    	}
    }
}
