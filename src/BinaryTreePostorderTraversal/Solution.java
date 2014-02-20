package BinaryTreePostorderTraversal;

import java.util.ArrayList;

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
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
