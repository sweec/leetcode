package RemoveDuplicatesFromSortedList;

import static org.junit.Assert.*;

import org.junit.Test;

import Utility.ListNode;

public class SolutionTest {

	@Test
	public void testDeleteDuplicates() {
		Solution s = new Solution();
		ListNode head = new ListNode(1);
		ListNode cur = head;
		int[] data = {1, 1, 2};
		for (int i = 1;i < data.length;i++) {
			ListNode node = new ListNode(data[i]);
			cur.next = node;
			cur = node;
		}
		head = s.deleteDuplicates(head);
		cur = head;
		int[] val = {1, 2};
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
		head = s.deleteDuplicates(head);
		cur = head;
		int[] val2 = {1, 2, 3};
		for (int i = 1;i <= val2.length;i++) {
			assertEquals("node "+i+" value not correct", val2[i-1], cur.val);
			cur = cur.next;
		}
		
	}

}
