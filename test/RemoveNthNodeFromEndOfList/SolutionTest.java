package RemoveNthNodeFromEndOfList;

import static org.junit.Assert.*;

import org.junit.Test;

import Utility.ListNode;

public class SolutionTest {

	@Test
	public void testRemoveNthFromEnd() {
		Solution s = new Solution();
		ListNode head = new ListNode(1);
		ListNode cur = head;
		int[] data = {1, 2, 3, 4, 5};
		for (int i = 1;i < data.length;i++) {
			ListNode node = new ListNode(data[i]);
			cur.next = node;
			cur = node;
		}
		int n = 2;
		head = s.removeNthFromEnd(head, n);
		cur = head;
		int[] val = {1, 2, 3, 5};
		for (int i = 1;i <= val.length;i++) {
			assertEquals("node "+i+" value not correct", val[i-1], cur.val);
			cur = cur.next;
		}
		
		n = 4;
		head = s.removeNthFromEnd(head, n);
		cur = head;
		int[] val2 = {2, 3, 5};
		for (int i = 1;i <= val2.length;i++) {
			assertEquals("node "+i+" value not correct", val2[i-1], cur.val);
			cur = cur.next;
		}
	}

}
