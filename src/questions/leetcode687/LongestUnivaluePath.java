package questions.leetcode687;

import questions.dataStructure.TreeNode;

public class LongestUnivaluePath {
    public int longest;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        longest = 0;
        visit(root, root.val);
        return longest;
    }
    public int visit(TreeNode node, int val) {
        //If node is null, return 0
        if (node == null) return 0;
        int left = visit(node.left, node.val);
        int right = visit(node.right, node.val);
        longest = Math.max(longest, left + right);
        if (node.val == val) return Math.max(left, right) + 1;
        return 0;
    }
}
