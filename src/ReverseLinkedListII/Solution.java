package ReverseLinkedListII;

import Utility.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = null, cur = head;
        int count = 1;
        while (count < m) {
        	pre = cur;
        	cur = cur.next;
        	count++;
        }
        ListNode nodeM = cur;
        ListNode next = cur.next;
        while (count < n) {
        	ListNode temp = next.next;
        	next.next = cur;
        	cur = next;
        	next = temp;
        	count++;
        }
        if (pre == null)
        	head = cur;
        else
        	pre.next = cur;
        nodeM.next = next;
        return head;
    }
}