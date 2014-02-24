package PathSum;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) 
        	return false;
        if (root.left != null || root.right != null) {
            sum -= root.val;
            if (hasPathSum(root.left, sum))
            	return true;
            if (hasPathSum(root.right, sum))
            	return true;
        } else if (sum == root.val)
        	return true;
        return false;
    }

    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
