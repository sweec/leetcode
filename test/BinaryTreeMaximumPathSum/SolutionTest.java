package BinaryTreeMaximumPathSum;

import static org.junit.Assert.*;

import org.junit.Test;

import Utility.TreeNode;

public class SolutionTest {

	@Test
	public void testMaxPathSum() {
		Solution s = new Solution();
		TreeNode root = new TreeNode(-3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		assertEquals("Max Path Sum not agree", 3, s.maxPathSum(root));
	}

}
