package questions.leetcode298;

import questions.dataStructure.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {
    int max;
    public int longestConsecutive(TreeNode root) {
        max = 0;
        if (root == null)
            return 0;
        dp(root, root.val-1, 0);
        return max;
    }

    private void dp(TreeNode node, int last_val, int cur_len) {
        if (node == null)
            return;
        if (node.val == last_val + 1)
            cur_len++;
        else
            cur_len = 1;
        max = Math.max(max, cur_len);

        dp(node.left, node.val, cur_len);
        dp(node.right, node.val, cur_len);
    }
}
