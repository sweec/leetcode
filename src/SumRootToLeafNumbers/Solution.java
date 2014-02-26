package SumRootToLeafNumbers;

public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null)
        	return 0;
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int num) {
    	num = num * 10 + root.val;
    	int sum = 0;
    	if (root.left != null)
    		sum += sumNumbers(root.left, num);
    	if (root.right != null)
    		sum += sumNumbers(root.right, num);
    	if (root.left == null && root.right == null)
    		sum += num;
    	return sum;
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
