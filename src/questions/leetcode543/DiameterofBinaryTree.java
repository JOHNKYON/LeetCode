package questions.leetcode543;

import questions.dataStructure.TreeNode;

public class DiameterofBinaryTree {
    int max = 1;

    public int diameterOfBinaryTree(TreeNode root) {

        depth(root);
        return max-1;
    }

    private int depth(TreeNode node){
        if (node == null)   return 0;

        int left = depth(node.left);
        int right = depth(node.right);

        max = Math.max(left+right+1, max);

        return Math.max(left, right)+1;
    }
}
