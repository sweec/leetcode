package Utility;

import java.util.ArrayList;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }
	
	public static TreeNode getTree(String[] vals) {
		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		list.add(root);
		getTree(list, vals, 1);
		return root;
	}
	
	public static void getTree(ArrayList<TreeNode> list, String[] vals, int index) {
		if (index > vals.length-1) return;
		ArrayList<TreeNode> nextlist = new ArrayList<TreeNode>();
		for (TreeNode node:list) {
			if (vals[index] != "#") {
				node.left = new TreeNode(Integer.parseInt(vals[index]));
				nextlist.add(node.left);
			}
			if (++index > vals.length-1) return;
			if (vals[index] != "#") {
				node.right = new TreeNode(Integer.parseInt(vals[index]));
				nextlist.add(node.right);
			}
			if (++index > vals.length-1) return;
		}
		getTree(nextlist, vals, index);
	}
}
