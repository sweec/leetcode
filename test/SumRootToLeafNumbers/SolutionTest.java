package SumRootToLeafNumbers;

import static org.junit.Assert.*;

import org.junit.Test;

import SumRootToLeafNumbers.Solution.TreeNode;

public class SolutionTest {

	@Test
	public void testSumNumbers() {
		Solution s = new Solution();
		TreeNode root = s.new TreeNode(1);
		root.left = s.new TreeNode(2);
		root.right = s.new TreeNode(3);
		root.left.left = s.new TreeNode(4);
		assertEquals("Summation is wrong", 137, s.sumNumbers(root));
	}

}
