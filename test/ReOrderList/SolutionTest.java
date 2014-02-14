package ReOrderList;

import static org.junit.Assert.*;

import org.junit.Test;

import ReOrderList.Solution.ListNode;

public class SolutionTest {

	@Test
	public void testReorderList() {
		Solution s = new Solution();
		ListNode head = s.new ListNode(1);
		ListNode cur = head;
		int[] data = {1, 2, 3, 4, 5, 6};
		for (int i = 1;i < data.length;i++) {
			ListNode node = s.new ListNode(data[i]);
			cur.next = node;
			cur = node;
		}
		s.reorderList(head);;
		cur = head;
		int[] val = {1, 6, 2, 5, 3, 4};
		for (int i = 1;i <= val.length;i++) {
			assertEquals("node "+i+" value not correct", val[i-1], cur.val);
			cur = cur.next;
		}
	}

}
