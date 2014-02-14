package LinkedListCycleII;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode cycleNode = getAnyCycleNode(head);
        if (cycleNode == null)
        	return null;
        ListNode cur = head;
        do {
        	if (cur == cycleNode)
        		break;
        	ListNode node = cycleNode.next;
        	while (node != cur && node != cycleNode)
        		node = node.next;
        	if (cur == node)
        		break;
        	cur = cur.next;
        } while (true);
        return cur;
    }
    
    private ListNode getAnyCycleNode(ListNode head) {
        ListNode run1 = head, run2 = head;
        while (run2 != null && run2.next != null) {
        	run2 = run2.next;
        	if (run2 == run1)
        		return run1;
        	run2 = run2.next;
        	if (run2 == run1)
        		return run1;
        	run1 = run1.next;
        }
        return null;
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
