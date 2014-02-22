package BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> lot = new ArrayList<ArrayList<Integer>>();
    	ArrayList<TreeNode> curLevel = new ArrayList<TreeNode>();
    	curLevel.add(root);
    	while (!curLevel.isEmpty()) {
    		ArrayList<Integer> vals = new ArrayList<Integer>();
    		ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
    		for (TreeNode n:curLevel) {
    			if (n != null) {
    				vals.add(n.val);
    				nextLevel.add(n.left);
    				nextLevel.add(n.right);
    			}
    		}
    		if (!vals.isEmpty())
    			lot.add(vals);
    		curLevel = nextLevel;
    	}
    	return lot;
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
