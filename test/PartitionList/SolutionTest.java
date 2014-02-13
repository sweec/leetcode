package PartitionList;

import static org.junit.Assert.*;

import org.junit.Test;

import PartitionList.Solution.ListNode;

public class SolutionTest {

	@Test
	public void testPartition() {
		Solution s = new Solution();
		ListNode head = s.new ListNode(1);
		ListNode cur = head;
		int[] data = {1, 4, 3, 2, 5, 2};
		for (int i = 1;i <= 5;i++) {
			ListNode node = s.new ListNode(data[i]);
			cur.next = node;
			cur = node;
		}
		int x = 3;
		head = s.partition(head, x);
		cur = head;
		int[] val = {1, 2, 2, 4, 3, 5};
		for (int i = 1;i <= val.length;i++) {
			assertEquals("node "+i+" value not correct", val[i-1], cur.val);
			cur = cur.next;
		}
		x = 4;
		head = s.partition(head, x);
		cur = head;
		int[] val2 = {1, 2, 2, 3, 4, 5};
		for (int i = 1;i <= val2.length;i++) {
			assertEquals("node "+i+" value not correct", val2[i-1], cur.val);
			cur = cur.next;
		}
	}

}
