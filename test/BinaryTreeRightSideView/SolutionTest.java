package BinaryTreeRightSideView;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Utility.TreeNode;

public class SolutionTest {

	@Test
	public void testRightSideViewTreeNode() {
		Solution s = new Solution();
		String[] vals = {"1", "2", "3", "#", "5", "#", "4", "#", "6"};
		TreeNode tree = TreeNode.getTree(vals);
		int[] view = {1, 3, 4, 6};
		List<Integer> viewlist = s.rightSideView(tree);
		assertEquals("view size not agree", view.length, viewlist.size());
		for (int i=0;i<view.length;i++)
			assertEquals((i+1)+"th data is wrong", new Integer(view[i]), viewlist.get(i));
	}

}
