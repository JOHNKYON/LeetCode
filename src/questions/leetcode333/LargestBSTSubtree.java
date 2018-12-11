package questions.leetcode333;

import questions.dataStructure.TreeNode;

public class LargestBSTSubtree {
    int ans;
    public int largestBSTSubtree(TreeNode root) {
        ans = 0;
        findBST(root);
        return ans;
    }

    private int[] findBST(TreeNode node) {
        int[] res = new int[3]; // res[] : count, min, max
        if (node == null)
            return res;

        int[] left = findBST(node.left);
        int[] right = findBST(node.right);

        if (left[0] != -1 && right[0] != -1 &&
                (left[0] == 0 || left[2] < node.val) &&
                (right[0] == 0 || right[1] > node.val)) {
            int curr = left[0] + right[0] + 1;
            ans = Math.max(ans, curr);
            res[0] = curr;
            res[1] = left[0] == 0? node.val : left[1];
            res[2] = right[0] == 0? node.val : right[2];
            return res;
        }

        res[0] = -1;
        return res;
    }
}
