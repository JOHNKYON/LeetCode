package questions.leetcode222;

import questions.dataStructure.TreeNode;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int depth = height(root);
        return depth < 0? 0 :
                height(root.right) == depth-1 ? (1<<depth) + countNodes(root.right): (1<< (depth-1)) + countNodes(root.left);
    }

    private int height(TreeNode node) {
        return node == null? -1: 1 + height(node.left);
    }
}
