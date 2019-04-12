package questions.leetcode111;

import questions.dataStructure.TreeNode;

public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else if (root.left != null)
            return minDepth(root.left) + 1;
        else
            return minDepth(root.right) + 1;
    }
}
