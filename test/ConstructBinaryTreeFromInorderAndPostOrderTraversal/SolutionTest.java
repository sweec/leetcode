package ConstructBinaryTreeFromInorderAndPostOrderTraversal;

import static org.junit.Assert.*;

import org.junit.Test;

import ConstructBinaryTreeFromInorderAndPostOrderTraversal.Solution.TreeNode;

public class SolutionTest {

	@Test
	public void testBuildTree() {
		Solution s = new Solution();
		int[] inorder = {1, 3, 2}, postorder = {1, 2, 3};
		TreeNode root = s.buildTree(inorder, postorder);
		assertEquals("root not agree", 3, root.val);
		assertEquals("left not agree", 1, root.left.val);
		assertEquals("right not agree", 2, root.right.val);
	}

}
