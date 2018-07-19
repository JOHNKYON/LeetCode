package questions.leetcode104;

import questions.dataStructure.TreeNode;

public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        return maxCurrently(root);
    }

    private int maxCurrently(TreeNode node){
        if(node == null)   return 0;

        int left = maxCurrently(node.left);
        int right = maxCurrently(node.right);

        return 1 + ((left > right)? left : right);
    }
}
