package RemoveNthNodeFromEndOfList;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head == null)
    		return null;
    	ListNode preN = head, cur = head;
    	int count = 1;
    	while (count <= n) {
    		cur = cur.next;
    		count++;
    	}
    	if (cur == null)
    		return head.next;
    	while (cur.next != null) {
    		cur = cur.next;
    		preN = preN.next;
    	}
    	preN.next = preN.next.next;
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
