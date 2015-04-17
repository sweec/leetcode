package BinaryTreeMaximumPathSum;

import Utility.TreeNode;

public class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null)
        	return 0;
        MaxData max = new MaxData();
        maxPathSum(root, max);
        return max.sum;
    }

    private void maxPathSum(TreeNode root, MaxData max) {
    	if (root.left == null && root.right == null) {
    		max.sum = root.val;
    		max.path = root.val;
    		return;
    	}
    	int sum = root.val, path = root.val;
        if (root.left != null) {
        	maxPathSum(root.left, max);
        	path = Math.max(path, root.val+max.path);
        	sum = Math.max(path, max.sum);
        }
        if (root.right != null) {
        	maxPathSum(root.right, max);
        	sum = Math.max(sum, max.sum);
        	sum = Math.max(sum, root.val+max.path);
        	sum = Math.max(sum, path+max.path);
        	path = Math.max(path, root.val+max.path);
        }
        max.sum = sum;
        max.path = path;
    }
    
    private class MaxData {
    	int sum;
    	int path;
    }
}
