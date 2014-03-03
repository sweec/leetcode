package ConstructBinaryTreeFromInorderAndPostOrderTraversal;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null)
        	return null;
        int len = inorder.length;
        if (len < 1 || len != postorder.length)
        	return null;
        return buildTree(inorder, 0, postorder, 0, len);
    }

    private TreeNode buildTree(int[] inorder, int beg1,
    		int[] postorder, int beg2, int len) {
    	TreeNode root = new TreeNode(postorder[beg2+len-1]);
    	int index = beg1;
    	while (index < beg1+len && inorder[index] != root.val)
    		index++;
    	if (index == beg1+len)
    		return null;
    	int lsize = index - beg1, rsize = len - lsize - 1;
    	if (lsize > 0)
    		root.left = buildTree(inorder, beg1, postorder, beg2, lsize);
    	if (rsize > 0)
    		root.right = buildTree(inorder, index+1, postorder, beg2+lsize, rsize);
    	return root;
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
