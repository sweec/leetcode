package RecoverBinarySearchTree;

import static org.junit.Assert.*;

import org.junit.Test;

import RecoverBinarySearchTree.Solution.TreeNode;

public class SolutionTest {

	@Test
	public void testRecoverTree() {
		Solution s = new Solution();
		TreeNode root = s.new TreeNode(1);
		root.right = s.new TreeNode(3);
		root.left = s.new TreeNode(2);
		s.recoverTree(root);
		assertEquals("node 1 not agree", 2, root.val);
		assertEquals("node 2 not agree", 1, root.left.val);
		assertEquals("node 3 not agree", 3, root.right.val);
	}

}
