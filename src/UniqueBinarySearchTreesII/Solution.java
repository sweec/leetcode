package UniqueBinarySearchTreesII;

import java.util.ArrayList;

public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
     	return generateTrees(1, n);
    }

    private ArrayList<TreeNode> generateTrees(int beg, int end) {
    	ArrayList<TreeNode> bsts = new ArrayList<TreeNode>();
    	if (beg == end) {
    		TreeNode head = new TreeNode(beg);
    		bsts.add(head);
    	} else if (beg < end) {
			for (TreeNode n:generateTrees(beg+1, end)) {
	    		TreeNode head = new TreeNode(beg);
	    		head.right = n;
	    		bsts.add(head);
			}
    		for (int i=beg+1;i<end;i++) {
    			ArrayList<TreeNode> lbsts = generateTrees(beg, i-1);
    			ArrayList<TreeNode> rbsts = generateTrees(i+1, end);
    			for (TreeNode l:lbsts)
    				for (TreeNode r:rbsts) {
    		    		TreeNode head = new TreeNode(i);
    		    		head.left = l;
    		    		head.right = r;
    		    		bsts.add(head);
    				}
    		}
    		for (TreeNode n:generateTrees(beg, end-1)) {
	    		TreeNode head = new TreeNode(end);
	    		head.left = n;
	    		bsts.add(head);
			}
    	} else {
    		bsts.add(null);
    	}
    	return bsts;
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; left = null; right = null; }
    }
}
