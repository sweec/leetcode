package BinaryTreeLevelOrderTraversalII;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Utility.TreeNode;

public class SolutionTest {

	@Test
	public void testLevelOrderBottom() {
		Solution s = new Solution();
		TreeNode r1 = new TreeNode(1);
		r1.left = new TreeNode(2);
		r1.right = new TreeNode(2);
		r1.left.left = new TreeNode(3);
		r1.left.right = new TreeNode(4);
		r1.right.left = new TreeNode(4);
		r1.right.right = new TreeNode(3);
		int[][] vals = {{3, 4, 4, 3}, {2, 2}, {1}};
		ArrayList<ArrayList<Integer>> lot = s.levelOrderBottom(r1);
		for (int i=0;i<vals.length;i++)
			for (int j=0;j<vals[i].length;j++)
				assertEquals((j+1)+"th value is wrong at level "+(i+1), (Integer)vals[i][j], lot.get(i).get(j));
		r1.left.right = r1.left.left;
		r1.left.left = null;
		r1.right.left = null;
		int[][] vals2 = {{3, 3}, {2, 2}, {1}};
		lot = s.levelOrderBottom(r1);
		for (int i=0;i<vals2.length;i++)
			for (int j=0;j<vals2[i].length;j++)
				assertEquals((j+1)+"th value is wrong at level "+(i+1), (Integer)vals2[i][j], lot.get(i).get(j));
		r1.val = 3;
		r1.left.val = 9;
		r1.right.val = 20;
		r1.right.left = r1.left.right;
		r1.right.left.val = 15;
		r1.left.right = null;
		r1.right.right.val = 7;
		int[][] vals3 = {{15, 7}, {9, 20}, {3}};
		lot = s.levelOrderBottom(r1);
		for (int i=0;i<vals3.length;i++)
			for (int j=0;j<vals3[i].length;j++)
				assertEquals((j+1)+"th value is wrong at level "+(i+1), (Integer)vals3[i][j], lot.get(i).get(j));
	}

}
