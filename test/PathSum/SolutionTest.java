package PathSum;

import static org.junit.Assert.*;

import org.junit.Test;

import Utility.TreeNode;

public class SolutionTest {

	@Test
	public void testHasPathSum() {
		Solution s = new Solution();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.right = new TreeNode(1);
		int sum = 22;
		assertEquals("Wrong result", true, s.hasPathSum(root, sum));
		sum = 23;
		assertEquals("Wrong result", false, s.hasPathSum(root, sum));
	}

}
