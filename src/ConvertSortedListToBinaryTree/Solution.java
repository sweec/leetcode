package ConvertSortedListToBinaryTree;

import Utility.ListNode;
import Utility.TreeNode;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
        	len++;
        	cur = cur.next;
        }
        if (len == 0)
        	return null;
        return sortedListToBST(head, len);
    }
    
    private TreeNode sortedListToBST(ListNode head, int len) {
    	int count = len/2;
    	int index = 0;
    	ListNode cur = head;
    	while (index < count) {
    		cur = cur.next;
    		index++;
    	}
    	TreeNode root = new TreeNode(cur.val);
    	if (count > 0)
    		root.left = sortedListToBST(head, count);
    	if (len > count+1)
    		root.right = sortedListToBST(cur.next, len-count-1);
    	return root;
    }
}
