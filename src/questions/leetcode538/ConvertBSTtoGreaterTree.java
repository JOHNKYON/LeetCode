package questions.leetcode538;

import questions.dataStructure.TreeNode;

public class ConvertBSTtoGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        modify(root, 0);
        return root;
    }

    private int modify(TreeNode node, int sum){
        if (node == null)   return sum;
        int temp = node.val;
        sum = modify(node.right, sum);
        node.val += sum;
        sum += temp;
        sum = modify(node.left, sum);
        return sum;
    }
}
