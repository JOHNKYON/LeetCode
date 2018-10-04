package questions.leetcode549;

import questions.dataStructure.TreeNode;

public class BinaryTreeLongestConsecutiveSequenceII {
    int max;

    public int longestConsecutive(TreeNode root) {
        max = 0;
        currLength(root);
        return max;
    }

    private int[] currLength(TreeNode node) {
        // int[0] increasing, int[1] decreasing
        int[] curr = new int[2];
        if (node == null)
            return curr;

        int[] left = currLength(node.left);
        int[] right = currLength(node.right);
        int increasing = 1;
        int decreasing = 1;

        if (node.left != null) {
            if (node.left.val + 1 == node.val)
                increasing = Math.max(increasing, left[0] + 1);
            if (node.left.val - 1 == node.val)
                decreasing = Math.max(decreasing, left[1] + 1);
        } if (node.right != null) {
            if (node.right.val + 1 == node.val)
                increasing = Math.max(increasing, right[0] + 1);
            if (node.right.val - 1 == node.val)
                decreasing = Math.max(decreasing, right[1] + 1);
        }
        curr[0] = increasing;
        curr[1] = decreasing;

        max = Math.max(Math.max(max, increasing), decreasing);

        if (node.left != null && node.right != null) {
            if (node.left.val + 1 == node.val && node.val + 1 == node.right.val)
                max = Math.max(max, left[0] + right[1] + 1);
            if (node.left.val - 1 == node.val && node.val - 1 == node.right.val)
                max = Math.max(max, left[1] + right[0] + 1);
        }

        return curr;
    }
}
