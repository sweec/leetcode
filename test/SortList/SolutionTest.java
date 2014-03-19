package SortList;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import SortList.Solution.ListNode;

public class SolutionTest {

	@Test
	public void testSortList() {
		Solution s = new Solution();
		int[] vals = {19, 13, 15, 9, 3, 4, 2, 1};
		ListNode head = s.new ListNode(0), cur = head;
		for (int i=0;i<vals.length;i++) {
			cur.next = s.new ListNode(vals[i]);
			cur = cur.next;
		}
		head = s.sortList(head.next);
		cur = head;
		Arrays.sort(vals);
		for (int i=0;i<vals.length;i++) {
			if (cur == null)
				fail((i+1)+"th node not available");
			assertEquals((i+1)+"th node not agree", vals[i], cur.val);
			cur = cur.next;
		}
	}

}
