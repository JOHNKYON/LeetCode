package questions.leetcode226;

import questions.dataStructure.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)   return root;
        if (root.left != null)
            invertTree(root.left);
        if (root.right != null)
            invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
