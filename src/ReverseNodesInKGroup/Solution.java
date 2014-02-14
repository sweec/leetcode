package ReverseNodesInKGroup;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
    	if (k < 2) return head;
    	ListNode fakeHead = new ListNode(0);
    	fakeHead.next = head;
		ListNode preK = fakeHead, cur = head;
		do {
			int count = 1;
			while (count < k && cur != null && cur.next != null) {
				cur = cur.next;
				count++;
			}
			// exit loop if reach end of list
			if (count < k)
				break;
			// reverse the k nodes
			ListNode after = cur.next;
			cur = preK.next;
			ListNode next = cur.next;
			while (next != after) {
				ListNode temp = next.next;
				next.next = cur;
				cur = next;
				next = temp;
			}
			// link with pre and after nodes
			next = preK.next;
			preK.next = cur;
			next.next = after;
			preK = next;
			cur = after;
		} while (true);
		return fakeHead.next;
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
