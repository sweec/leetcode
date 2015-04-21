package BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;

import Utility.TreeNode;

public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
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
    	int a = 0, b = lot.size() - 1;
    	while (a < b) {
    		ArrayList<Integer> temp = lot.get(b);
    		lot.set(b, lot.get(a));
    		lot.set(a, temp);
    		a++;
    		b--;
    	}
    	return lot;
    }
}
