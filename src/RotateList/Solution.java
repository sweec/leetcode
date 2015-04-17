package RotateList;

import Utility.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null)
        	return head;
        ListNode preN = head, cur = head;
        // search for node that is n nodes away from head
        int count = 1;
        while (count <= n) {
        	cur = cur.next;
        	if (cur == null)
        		cur = head;
        	count++;
        }
        // if rotates back, nothing need to do
        if (cur == head)
        	return head;
        // move preN, cur until cur become last node
        while (cur.next != null) {
        	cur = cur.next;
        	preN = preN.next;
        	if (preN == null)
        		preN = head;
        }
        cur.next = head;
        head = preN.next;
        preN.next = null;
        return head;
    }
}
