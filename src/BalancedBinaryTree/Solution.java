package BalancedBinaryTree;

import Utility.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) >= 0;
    }
    
    // -1 means not balanced
    private int getHeight(TreeNode root) {
    	if (root == null)
    		return 0;
    	int h1 = getHeight(root.left);
    	if (h1 < 0)
    		return -1;
    	int h2 = getHeight(root.right);
    	if (h2 < 0)
    		return -1;
    	if (Math.abs(h1-h2) > 1)
    		return -1;
    	return Math.max(h1, h2)+1;
    }
}
