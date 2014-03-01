package UniqueBinarySearchTreesII;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import UniqueBinarySearchTreesII.Solution.TreeNode;

public class SolutionTest {

	private int getPreOrder(TreeNode head, int[] vals, int index) {
		int count = 1;
		vals[index] = head.val;
		if (head.left != null)
			count += getPreOrder(head.left, vals, index+count);
		if (head.right != null)
			count += getPreOrder(head.right, vals, index+count);
		return count;
	}
	
	@Test
	public void testGenerateTrees() {
		Solution s = new Solution();
		int[][] answer = {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {3, 1, 2}, {3, 2, 1}};
		int n = 3;
		ArrayList<TreeNode> bsts = s.generateTrees(n);
		assertEquals("BST number is wrong", answer.length, bsts.size());
		for (int i=0;i<answer.length;i++) {
			int[] vals = new int[n];
			getPreOrder(bsts.get(i), vals, 0);
			for (int j=0;j<n;j++)
				assertEquals((j+1)+"th node has wrong value at BST "+(i+1), answer[i][j], vals[j]);
		}
	}

}
