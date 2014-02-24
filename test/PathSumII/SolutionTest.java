package PathSumII;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import PathSumII.Solution.TreeNode;

public class SolutionTest {

	@Test
	public void testPathSum() {
		Solution s = new Solution();
		TreeNode root = s.new TreeNode(5);
		root.left = s.new TreeNode(4);
		root.right = s.new TreeNode(8);
		root.left.left = s.new TreeNode(11);
		root.right.left = s.new TreeNode(13);
		root.right.right = s.new TreeNode(4);
		root.left.left.left = s.new TreeNode(7);
		root.left.left.right = s.new TreeNode(2);
		root.right.right.left = s.new TreeNode(5);
		root.right.right.right = s.new TreeNode(1);
		int sum = 22;
		int[][] answer = {{5, 4, 11, 2}, {5, 8, 4, 5}};
		ArrayList<ArrayList<Integer>> paths = s.pathSum(root, sum);
		for (int i=0;i<answer.length;i++)
			for (int j=0;j<answer[i].length;j++)
				assertEquals((j+1)+"th value is wrong at path "+(i+1), (Integer)answer[i][j], paths.get(i).get(j));
	}

}
