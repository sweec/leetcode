package SymmetricTree;

import java.util.Stack;

import Utility.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
        	return true;
        Stack<TreeNode> ls = new Stack<TreeNode>();
        Stack<TreeNode> rs = new Stack<TreeNode>();
        TreeNode ln = root.left, rn = root.right;
        do {
        	if (ln == null && rn == null) {
        		if (ls.isEmpty() && rs.isEmpty())
        			return true;
        		else if (ls.isEmpty() || rs.isEmpty())
        			return false;
        		ln = ls.pop();
        		rn = rs.pop();
        	} else if (ln == null || rn == null)
        		return false;
        	else if (ln.val != rn.val)
        		return false;
        	else {
        		ls.push(ln.right);
        		rs.push(rn.left);
        		ln = ln.left;
        		rn = rn.right;
        	}
        } while (true);
        
    }
}
