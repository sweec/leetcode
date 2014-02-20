package PopulatingNextRightPointers;

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
        	return;
        connect(root.left);
        connect(root.right);
        TreeLinkNode n1 = root.left, n2 = root.right;
        while (n1 != null && n2 != null) {
        	n1.next = n2;
        	n1 = n1.right;
        	n2 = n2.left;
        }
    }

    public class TreeLinkNode {
    	int val;
    	TreeLinkNode left, right, next;
    	TreeLinkNode(int x) { val = x; }
    }
}
