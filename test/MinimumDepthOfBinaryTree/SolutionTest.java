package MinimumDepthOfBinaryTree;

import static org.junit.Assert.*;

import org.junit.Test;

import Utility.TreeNode;

public class SolutionTest {

	@Test
	public void testMinDepth() {
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		assertEquals("Minimum depth is wrong", 3, s.minDepth(root));
	}

}
