package ReverseLinkedListII;

import static org.junit.Assert.*;

import org.junit.Test;

import Utility.ListNode;

public class SolutionTest {

	@Test
	public void testReverseBetween() {
		Solution s = new Solution();
		ListNode head = new ListNode(1);
		ListNode cur = head;
		for (int i = 2;i <= 5;i++) {
			ListNode node = new ListNode(i);
			cur.next = node;
			cur = node;
		}
		int m = 2, n = 4;
		head = s.reverseBetween(head, m, n);
		cur = head;
		int[] val = {1, 4, 3, 2, 5};
		for (int i = 1;i <= 5;i++) {
			assertEquals("node "+i+" value not correct", val[i-1], cur.val);
			cur = cur.next;
		}
		m = 1; n = 3;
		head = s.reverseBetween(head, m, n);
		cur = head;
		int[] val2 = {3, 4, 1, 2, 5};
		for (int i = 1;i <= 5;i++) {
			assertEquals("node "+i+" value not correct", val2[i-1], cur.val);
			cur = cur.next;
		}
	}

}