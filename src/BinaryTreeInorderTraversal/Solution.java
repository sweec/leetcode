package BinaryTreeInorderTraversal;

import java.util.ArrayList;

import Utility.TreeNode;

public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
    	ArrayList<Integer> vals = new ArrayList<Integer>();
    	inorderTraversal(root, vals);
    	return vals;
    }

    private void inorderTraversal(TreeNode root, ArrayList<Integer> vals) {
    	if (root != null) {
    		inorderTraversal(root.left, vals);
    		vals.add(root.val);
    		inorderTraversal(root.right, vals);
    	}
    }
}
