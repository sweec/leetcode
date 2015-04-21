package BalancedBinaryTree;

import static org.junit.Assert.*;

import org.junit.Test;

import Utility.TreeNode;

public class SolutionTest {

	@Test
	public void testIsBalanced() {
		Solution s = new Solution();
		TreeNode r1 = new TreeNode(1);
		r1.left = new TreeNode(2);
		r1.right = new TreeNode(2);
		r1.left.left = new TreeNode(3);
		r1.left.right = new TreeNode(4);
		r1.right.left = new TreeNode(4);
		r1.right.right = new TreeNode(3);
		assertEquals("Get wrong balance", true, s.isBalanced(r1));
		r1.left.right = r1.left.left;
		r1.left.left = null;
		r1.right.left = null;
		assertEquals("Get wrong symmetry", true, s.isBalanced(r1));
	}

}
