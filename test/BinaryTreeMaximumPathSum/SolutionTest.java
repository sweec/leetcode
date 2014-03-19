package BinaryTreeMaximumPathSum;

import static org.junit.Assert.*;

import org.junit.Test;

import BinaryTreeMaximumPathSum.Solution.TreeNode;

public class SolutionTest {

	@Test
	public void testMaxPathSum() {
		Solution s = new Solution();
		TreeNode root = s.new TreeNode(-3);
		root.left = s.new TreeNode(2);
		root.right = s.new TreeNode(3);
		assertEquals("Max Path Sum not agree", 3, s.maxPathSum(root));
	}

}
