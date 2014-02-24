package PathSum;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) 
        	return false;
        sum -= root.val;
        if (root.left != null && hasPathSum(root.left, sum))
        	return true;
        if (root.right != null && hasPathSum(root.right, sum))
        	return true;
        if (root.left == null && root.right == null && sum == 0)
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
