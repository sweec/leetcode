package FlattenBinaryTreeToLinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

import FlattenBinaryTreeToLinkedList.Solution.TreeNode;

public class SolutionTest {

	@Test
	public void testFlatten() {
		Solution s = new Solution();
		TreeNode root = s.new TreeNode(1);
		root.left = s.new TreeNode(2);
		root.right = s.new TreeNode(5);
		root.left.left = s.new TreeNode(3);
		root.left.right = s.new TreeNode(4);
		root.right.right = s.new TreeNode(6);
		s.flatten(root);
		int[] answer = {1, 2, 3, 4, 5, 6};
		TreeNode cur = root;
		for (int i=0;i<answer.length;i++) {
			assertEquals((i+1)+"th value is wrong", answer[i], cur.val);
			cur = cur.right;
		}
	}

}
