package questions.leetcode257;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;

        addPath(root, "");
        return res;
    }

    public BinaryTreePaths(){
        res = new ArrayList<>();
    }

    private void addPath(TreeNode node, String s){
        if (node.left == null && node.right == null) res.add(s+String.valueOf(node.val));
        if (node.left != null) addPath(node.left, s+String.valueOf(node.val)+"->");
        if (node.right != null) addPath(node.right, s+String.valueOf(node.val)+"->");
    }

    /**
     * Definition for a binary tree node.
     **/
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

}
