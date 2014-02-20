package BinaryTreePostorderTraversal;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import BinaryTreePostorderTraversal.Solution.TreeNode;

public class SolutionTest {

	@Test
	public void testPostorderTraversal() {
		Solution s = new Solution();
		TreeNode root = s.new TreeNode(1);
		TreeNode right = s.new TreeNode(2);
		root.right = right;
		TreeNode left = s.new TreeNode(3);
		right.left = left;
		int[] vals = {3, 2, 1};
		ArrayList<Integer> vs = s.postorderTraversal(root);
		for (int i=0;i<vs.size();i++)
			assertEquals((i+1)+"th value not correct", (Integer)vals[i], vs.get(i));
	}

}
