package MinimumDepthOfBinaryTree;

import java.util.ArrayList;

import Utility.TreeNode;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
        	return 0;
        int min = 0;
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
        cur.add(root);
        while (!cur.isEmpty()) {
        	min++;
        	ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        	for (TreeNode n:cur) {
        		if (n.left != null)
        			next.add(n.left);
        		if (n.right != null)
        			next.add(n.right);
        		if (n.left == null && n.right == null)
        			return min;
        	}
        	cur = next;
        }
        return min;
    }
}
