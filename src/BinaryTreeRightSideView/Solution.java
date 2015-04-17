package BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Utility.TreeNode;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<Integer>();
        if (root == null) return view;
        // method 1 recursive, 284ms
        //rightSideView(root, view, 1);
        
        // method 2 stack, 255ms
        Stack<TreeNode> sNode = new Stack<TreeNode>();
        Stack<Integer> sLevel = new Stack<Integer>();
        sNode.push(root);
        sLevel.push(1);
        while (!sNode.empty()) {
            TreeNode node = sNode.pop();
            int level = sLevel.pop();
            if (level > view.size()) view.add(node.val);
            if (node.left != null) {
                sNode.push(node.left);
                sLevel.push(level+1);
            }
            if (node.right != null) {
                sNode.push(node.right);
                sLevel.push(level+1);
            }
        }
        return view;
    }
    /*
    public void rightSideView(TreeNode node, List<Integer> view, int level) {
        if (node == null) return;
        if (level > view.size()) view.add(node.val);
        rightSideView(node.right, view, level+1);
        rightSideView(node.left, view, level+1);
    }*/
}