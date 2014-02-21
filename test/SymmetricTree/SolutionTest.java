package SymmetricTree;

import static org.junit.Assert.*;

import org.junit.Test;

import SymmetricTree.Solution.TreeNode;

public class SolutionTest {

	@Test
	public void testIsSymmetric() {
		Solution s = new Solution();
		TreeNode r1 = s.new TreeNode(1);
		r1.left = s.new TreeNode(2);
		r1.right = s.new TreeNode(2);
		r1.left.left = s.new TreeNode(3);
		r1.left.right = s.new TreeNode(4);
		r1.right.left = s.new TreeNode(4);
		r1.right.right = s.new TreeNode(3);
		assertEquals("Get wrong symmetry", true, s.isSymmetric(r1));
		r1.left.right = r1.left.left;
		r1.left.left = null;
		r1.right.left = null;
		assertEquals("Get wrong symmetry", false, s.isSymmetric(r1));
	}

}
