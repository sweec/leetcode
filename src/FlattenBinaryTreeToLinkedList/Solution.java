package FlattenBinaryTreeToLinkedList;

import java.util.Stack;

public class Solution {
    public void flatten(TreeNode root) {
    	if (root == null)
    		return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        do {
        	if (cur.left != null) {
            	if (cur.right != null)
            		s.push(cur.right);
        		cur.right = cur.left;
        		cur = cur.left;
        	} else if (cur.right != null)
        		cur = cur.right;
        	else if (!s.isEmpty()){
        		TreeNode next = s.pop();
        		cur.right = next;
        		cur = next;
        	} else
        		break;
        } while (true);
    }

    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
