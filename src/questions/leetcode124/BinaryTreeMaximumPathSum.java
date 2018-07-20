package questions.leetcode124;

import questions.dataStructure.TreeNode;

public class BinaryTreeMaximumPathSum {
    private int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxHere(root);

        return max;
    }

    private int maxHere(TreeNode node){
        if(node == null)    return 0;

        int left = maxHere(node.left);
        int right = maxHere(node.right);
        int max_here = node.val;
        int max_as_root = node.val;

        int max_child = Math.max(left, right);

        if(left > 0)    max_as_root += left;
        if(right > 0)   max_as_root += right;

        if (max_child > 0)  max_here += max_child;

        max = (max > max_as_root)? max : max_as_root;

        return max_here;
    }
}
