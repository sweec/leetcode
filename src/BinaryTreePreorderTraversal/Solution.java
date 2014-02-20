package BinaryTreePreorderTraversal;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
    	ArrayList<Integer> vals = new ArrayList<Integer>();
    	preorderTraversal(root, vals);
    	return vals;
    }

    private void preorderTraversal(TreeNode root, ArrayList<Integer> vals) {
    	if (root != null) {
    		vals.add(root.val);
    		preorderTraversal(root.left, vals);
    		preorderTraversal(root.right, vals);
    	}
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
