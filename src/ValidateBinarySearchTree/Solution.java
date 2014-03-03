package ValidateBinarySearchTree;

public class Solution {
    public boolean isValidBST(TreeNode root) {
    	if (root == null)
    		return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
    	if ((long)root.val <= min || (long)root.val >= max)
    		return false;
    	if (root.left != null && !isValidBST(root.left, min, root.val))
    			return false;
    	if (root.right != null && !isValidBST(root.right, root.val, max))
    			return false;
    	return true;
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
