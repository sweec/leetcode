package MergeTwoSortedLists;

import static org.junit.Assert.*;

import org.junit.Test;

import Utility.ListNode;

public class SolutionTest {

	@Test
	public void testMergeTwoLists() {
		Solution s = new Solution();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);
		ListNode cur = s.mergeTwoLists(l1, l2);
		int[] val = {1, 2, 3, 4};
		for (int i=0;i<val.length;i++) {
			assertEquals((i+1)+"th value is wrong", val[i], cur.val);
			cur = cur.next;
		}
	}

}
