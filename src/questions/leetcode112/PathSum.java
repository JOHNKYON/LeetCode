package questions.leetcode112;

import questions.dataStructure.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return preOrder(root, 0, sum);
    }

    private boolean preOrder(TreeNode node, int curr, int target) {
        if (node == null)
            return false;
        curr += node.val;
        if (node.left == null && node.right == null)
            return curr == target;
        return preOrder(node.left, curr, target) || preOrder(node.right, curr, target);
    }
}
