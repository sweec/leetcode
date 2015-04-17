package SumRootToLeafNumbers;

import static org.junit.Assert.*;

import org.junit.Test;

import Utility.TreeNode;

public class SolutionTest {

	@Test
	public void testSumNumbers() {
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		assertEquals("Summation is wrong", 137, s.sumNumbers(root));
	}

}
