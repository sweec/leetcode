package ValidateBinarySearchTree;

import static org.junit.Assert.*;

import org.junit.Test;

import Utility.TreeNode;

public class SolutionTest {

	@Test
	public void testIsValidBST() {
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		assertEquals("failed to validate BST", false, s.isValidBST(root));
		root.right.right = root.right.left;
		root.right.left = null;
		assertEquals("failed to validate BST", true, s.isValidBST(root));
	}

}
