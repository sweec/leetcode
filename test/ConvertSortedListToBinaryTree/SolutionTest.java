package ConvertSortedListToBinaryTree;

import static org.junit.Assert.*;

import org.junit.Test;

import Utility.ListNode;
import Utility.TreeNode;

public class SolutionTest {

	@Test
	public void testSortedListToBST() {
		Solution s = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		TreeNode tr = s.sortedListToBST(head);
		assertEquals("root value wrong", 3, tr.val);
		assertEquals("root.left value wrong", 2, tr.left.val);
		assertEquals("root.left.left value wrong", 1, tr.left.left.val);
		assertEquals("root.right value wrong", 4, tr.right.val);
	}

}
