package MinimumDepthOfBinaryTree;

import static org.junit.Assert.*;

import org.junit.Test;

import MinimumDepthOfBinaryTree.Solution.TreeNode;

public class SolutionTest {

	@Test
	public void testMinDepth() {
		Solution s = new Solution();
		TreeNode root = s.new TreeNode(1);
		root.left = s.new TreeNode(2);
		root.right = s.new TreeNode(3);
		root.left.left = s.new TreeNode(4);
		root.right.right = s.new TreeNode(5);
		assertEquals("Minimum depth is wrong", 3, s.minDepth(root));
	}

}
