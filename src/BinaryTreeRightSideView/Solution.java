package BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;
import Utility.TreeNode;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<Integer>();
        if (root == null) return view;
        // method 1 recursive, 284ms
        //rightSideView(root, view, 1);
        
        // method 2 stack, 255ms
        /*
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
        }*/
        
        // method 3 record each layer, 277ms
        /*
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        while (!list.isEmpty()) {
            view.add(list.get(0).val);
            ArrayList<TreeNode> next = new ArrayList<TreeNode>();
            for (TreeNode node:list) {
                if (node.right != null)
                    next.add(node.right);
                if (node.left != null)
                    next.add(node.left);
            }
            list = next;
        }*/
        
        // method 4 recursive on left and right, compare and merge, 274ms
        view.add(root.val);
        List<Integer> leftview = rightSideView(root.left);
        List<Integer> rightview = rightSideView(root.right);
        for (int val:rightview) view.add(val);
        for (int i=rightview.size();i<leftview.size();i++)
        	view.add(leftview.get(i));
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