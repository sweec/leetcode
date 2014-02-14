package ReverseNodesInKGroup;

import static org.junit.Assert.*;

import org.junit.Test;

import ReverseNodesInKGroup.Solution.ListNode;

public class SolutionTest {

	@Test
	public void testReverseKGroup() {
		Solution s = new Solution();
		ListNode head = s.new ListNode(1);
		ListNode cur = head;
		int[] data = {1, 2, 3, 4, 5};
		for (int i = 1;i < data.length;i++) {
			ListNode node = s.new ListNode(data[i]);
			cur.next = node;
			cur = node;
		}
		int k = 2;
		head = s.reverseKGroup(head, k);
		cur = head;
		int[] val = {2, 1, 4, 3, 5};
		for (int i = 1;i <= val.length;i++) {
			assertEquals("node "+i+" value not correct", val[i-1], cur.val);
			cur = cur.next;
		}
		
		k = 3;
		head = s.reverseKGroup(head, k);
		cur = head;
		int[] val2 = {4, 1, 2, 3, 5};
		for (int i = 1;i <= val2.length;i++) {
			assertEquals("node "+i+" value not correct", val2[i-1], cur.val);
			cur = cur.next;
		}
	}

}
