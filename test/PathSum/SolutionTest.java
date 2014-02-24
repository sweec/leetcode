package PathSum;

import static org.junit.Assert.*;

import org.junit.Test;

import PathSum.Solution.TreeNode;

public class SolutionTest {

	@Test
	public void testHasPathSum() {
		Solution s = new Solution();
		TreeNode root = s.new TreeNode(5);
		root.left = s.new TreeNode(4);
		root.right = s.new TreeNode(8);
		root.left.left = s.new TreeNode(11);
		root.right.left = s.new TreeNode(13);
		root.right.right = s.new TreeNode(4);
		root.left.left.left = s.new TreeNode(7);
		root.left.left.right = s.new TreeNode(2);
		root.right.right.right = s.new TreeNode(1);
		int sum = 22;
		assertEquals("Wrong result", true, s.hasPathSum(root, sum));
		sum = 23;
		assertEquals("Wrong result", false, s.hasPathSum(root, sum));
	}

}
