package questions.leetcode337;

import questions.dataStructure.TreeNode;

public class HouseRobber3 {
    public int rob(TreeNode root) {
        int[] res = maxAmount(root);
        return Math.max(res[0], res[1]);
    }

    private int[] maxAmount(TreeNode node){
        int[] max = new int[2];
        if (node == null)   return max;


        int[] left = maxAmount(node.left);
        int[] right = maxAmount(node.right);

        int max_with=0;
        max[0] = left[1] + right[1] + node.val;

        int left_max = Math.max(left[0], left[1]);
        int right_max = Math.max(right[0], right[1]);

        max[1] = left_max + right_max;

        return max;
    }
}
