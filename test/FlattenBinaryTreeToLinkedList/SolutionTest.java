package FlattenBinaryTreeToLinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

import Utility.TreeNode;

public class SolutionTest {

	@Test
	public void testFlatten() {
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);
		s.flatten(root);
		int[] answer = {1, 2, 3, 4, 5, 6};
		TreeNode cur = root;
		for (int i=0;i<answer.length;i++) {
			assertEquals((i+1)+"th value is wrong", answer[i], cur.val);
			cur = cur.right;
		}
	}

}
