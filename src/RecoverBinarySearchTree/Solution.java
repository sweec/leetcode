package RecoverBinarySearchTree;

public class Solution {
    public void recoverTree(TreeNode root) {
    	// Used Morris Traversal with hint from leetcode discuss
        TreeNode n1 = null, n2 = null;
        TreeNode pre = null, cur = root;
        while (cur != null) {
        	if (cur.left == null) {
        		if (pre != null && pre.val > cur.val) {
        			if (n1 == null) {
        				n1 = pre;
        				n2 = cur;
        			} else
        				n2 = cur;
        		}
        		pre = cur;
        		cur = cur.right;
        	} else {
        		TreeNode lt = cur.left;
        		while (lt.right != null && lt.right != cur)
        			lt = lt.right;
        		if (lt.right == null) {
        			lt.right = cur;
        			cur = cur.left;
        		} else {
        			lt.right = null;
            		if (pre != null && pre.val > cur.val) {
            			if (n1 == null) {
            				n1 = pre;
            				n2 = cur;
            			} else
            				n2 = cur;
            		}
            		pre = cur;
            		cur = cur.right;
        		}
        	}
        }
        if (n1 != null && n2 != null) {
        	int temp = n1.val;
        	n1.val = n2.val;
        	n2.val = temp;
        }
    }

    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
