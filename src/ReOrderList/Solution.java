package ReOrderList;

public class Solution {
    public void reorderList(ListNode head) {
    	// get the length of list
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
        	len++;
        	cur = cur.next;
        }
        if (len < 3)
        	return;
        // get next half of list
        len /= 2;
        cur = head;
        for (int i = 0;i < len;i++)
        	cur = cur.next;
        // reverse next half list
        ListNode next = cur.next;
        cur.next = null;
        while (next != null) {
        	ListNode temp = next.next;
        	next.next = cur;
        	cur = next;
        	next = temp;
        }
        // merge back two half lists
        ListNode node1 = head; 
        ListNode node2 = new ListNode(0);
        node2.next = cur;
        for (int i = 0;i < len;i++) {
        	ListNode temp = node2.next;
        	node2.next = node1;
        	node1 = node1.next;
        	node2.next.next = temp;
        	node2 = temp;
        }
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
