package LinkedListCycleII;

import static org.junit.Assert.*;

import org.junit.Test;

import Utility.ListNode;

public class SolutionTest {

	@Test
	public void testDetectCycle() {
		Solution s = new Solution();
		ListNode head = new ListNode(1);
		ListNode cur = head, mid = null, node = head;
		int[] data = {1, 4, 3, 2, 5, 2};
		for (int i = 1;i <= 5;i++) {
			node = new ListNode(data[i]);
			cur.next = node;
			cur = node;
			if (i ==2)
				mid = node;
		}
		if (s.detectCycle(head) != null)
			fail("The list should has no cylce");
		node.next = mid;
		assertEquals("The list's cycle is not detected or start node is wrong", 3, s.detectCycle(head).val);
	}

}
