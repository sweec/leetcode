package SwapNodesInPairs;

public class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		// swap first 2 nodes
		ListNode pre = head;
		head = head.next;
		ListNode cur = head.next;
		head.next = pre;
		pre.next = cur;
		// swap latter node pairs
		while (cur != null && cur.next != null) {
			ListNode temp = cur.next.next;
			pre.next = cur.next;
			cur.next.next = cur;
			cur.next = temp;
			pre = cur;
			cur = temp;
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
