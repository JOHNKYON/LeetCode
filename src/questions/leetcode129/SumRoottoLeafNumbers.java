package questions.leetcode129;

import questions.dataStructure.TreeNode;

public class SumRoottoLeafNumbers {
    int ans;
    public int sumNumbers(TreeNode root) {
        ans = 0;
        preorder(root, 0);
        return ans;
    }

    private void preorder(TreeNode node, int prefix) {
        if (node == null)
            return;
        int val = prefix * 10 + node.val;
        if (node.left == null && node.right == null) {
            ans += val;
        }
        preorder(node.left, val);
        preorder(node.right, val);
    }
}
