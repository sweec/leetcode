package BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;

import Utility.TreeNode;

public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> vals = new ArrayList<ArrayList<Integer>>();
    	if (root == null)
    		return vals;
    	ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
    	cur.add(root);
    	boolean goLeft = true;
    	while (!cur.isEmpty()) {
    		ArrayList<Integer> val = new ArrayList<Integer>();
    		ArrayList<TreeNode> next = new ArrayList<TreeNode>();
    		for (TreeNode n:cur) {
    			if (goLeft)
    				val.add(n.val);
    			else
    				val.add(0, n.val);
    			if (n.left != null)
    				next.add(n.left);
    			if (n.right != null)
    				next.add(n.right);
    		}
    		vals.add(val);
    		cur = next;
    		goLeft = !goLeft;
    	}
    	return vals;
    }
}
