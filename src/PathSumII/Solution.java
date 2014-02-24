package PathSumII;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        if (root == null) 
        	return paths;
        if (root.left != null || root.right != null) {
            sum -= root.val;
        	ArrayList<ArrayList<Integer>> lPaths = pathSum(root.left, sum);
        	ArrayList<ArrayList<Integer>> rPaths = pathSum(root.right, sum);
        	for (ArrayList<Integer> path:lPaths) {
        		path.add(0, root.val);
        		paths.add(path);
        	}
        	for (ArrayList<Integer> path:rPaths) {
        		path.add(0, root.val);
        		paths.add(path);
        	}
        } else if (sum == root.val) {
        	ArrayList<Integer> path = new ArrayList<Integer>();
        	path.add(root.val);
        	paths.add(path);
        }
        return paths;
    }

    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
