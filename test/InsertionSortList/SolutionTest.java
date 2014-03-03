package InsertionSortList;

import static org.junit.Assert.*;

import org.junit.Test;

import InsertionSortList.Solution.ListNode;

public class SolutionTest {

	@Test
	public void testInsertionSortList() {
		Solution s = new Solution();
		ListNode head = s.new ListNode(2);
		head.next = s.new ListNode(1);
		head.next.next = s.new ListNode(3);
		head = s.insertionSortList(head);
		assertEquals("node 1 not agree", 1, head.val);
		assertEquals("node 2 not agree", 2, head.next.val);
		assertEquals("node 3 not agree", 3, head.next.next.val);
	}

}
