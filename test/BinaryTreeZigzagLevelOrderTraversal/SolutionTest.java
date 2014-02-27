package BinaryTreeZigzagLevelOrderTraversal;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import BinaryTreeZigzagLevelOrderTraversal.Solution.TreeNode;

public class SolutionTest {

	@Test
	public void testZigzagLevelOrder() {
		Solution s = new Solution();
		TreeNode root = s.new TreeNode(3);
		root.left = s.new TreeNode(9);
		root.right = s.new TreeNode(20);
		root.right.left = s.new TreeNode(15);
		root.right.right = s.new TreeNode(7);
		int[][] answer = {{3}, {20, 9}, {15, 7}};
		ArrayList<ArrayList<Integer>> vals = s.zigzagLevelOrder(root);
		for (int i=0;i<answer.length;i++) {
			assertEquals("Size is wrong for layer "+(i+1), answer[i].length, vals.get(i).size());
			for (int j=0;j<answer[i].length;j++)
				assertEquals((j+1)+"th value is wrong at layer "+(i+1), (Integer)answer[i][j], vals.get(i).get(j));
		}
	}

}
