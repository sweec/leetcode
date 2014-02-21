package ConvertSortedArrayToBinarySearchTree;

public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length < 1)
        	return null;
        return sortedArrayToBST(num, 0, num.length);
    }

    private TreeNode sortedArrayToBST(int[] num, int beg, int end) {
    	if (beg >= end)
    		return null;
    	int len = end - beg;
    	if (len == 1)
    		return new TreeNode(num[beg]);
    	int index = beg + len/2;
    	TreeNode root = new TreeNode(num[index]);
    	root.left = sortedArrayToBST(num, beg, index);
    	root.right = sortedArrayToBST(num, index+1, end);
    	return root;
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
