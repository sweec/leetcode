package RotateList;

import static org.junit.Assert.*;

import org.junit.Test;

import Utility.ListNode;

public class SolutionTest {

	@Test
	public void testRotateRight() {
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
		head = s.rotateRight(head, n);
		cur = head;
		int[] val = {4, 5, 1, 2, 3};
		for (int i = 1;i <= val.length;i++) {
			assertEquals("node "+i+" value not correct", val[i-1], cur.val);
			cur = cur.next;
		}
		
		head = new ListNode(1);
		cur = head;
		int[] data2 = {1, 1, 2, 3, 3};
		for (int i = 1;i < data2.length;i++) {
			ListNode node = new ListNode(data2[i]);
			cur.next = node;
			cur = node;
		}
		n = 10;
		head = s.rotateRight(head, n);
		cur = head;
		int[] val2 = {1, 1, 2, 3, 3};
		for (int i = 1;i <= val2.length;i++) {
			assertEquals("node "+i+" value not correct", val2[i-1], cur.val);
			cur = cur.next;
		}
	}

}
