package PopulatingNextRightPointersII;

public class Solution {
    public void connect(TreeLinkNode root) {
        while (root != null) {
        	TreeLinkNode head = null, cur = null, pre = root;
        	while (pre != null) {
        		if (pre.left != null) {
        			if (cur != null)
        				cur.next = pre.left;
        			else
        				head = pre.left;
        			cur = pre.left;
        		}
        		if (pre.right != null) {
        			if (cur != null)
        				cur.next = pre.right;
        			else
        				head = pre.right;
        			cur = pre.right;
        		}
        		pre = pre.next;
        	}
        	root = head;
        }
    }

    public class TreeLinkNode {
    	int val;
    	TreeLinkNode left, right, next;
    	TreeLinkNode(int x) { val = x; }
    }
}
