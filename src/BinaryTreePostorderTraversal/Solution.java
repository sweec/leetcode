package BinaryTreePostorderTraversal;

import java.util.ArrayList;

import Utility.TreeNode;

public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
    	ArrayList<Integer> vals = new ArrayList<Integer>();
    	postorderTraversal(root, vals);
    	return vals;
    }

    private void postorderTraversal(TreeNode root, ArrayList<Integer> vals) {
    	if (root != null) {
    		postorderTraversal(root.left, vals);
    		postorderTraversal(root.right, vals);
    		vals.add(root.val);
    	}
    }
}
