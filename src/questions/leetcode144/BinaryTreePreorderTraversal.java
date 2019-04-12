package questions.leetcode144;

import questions.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr == null) {
                curr = stack.pop().right;
            } else {
                ans.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
        }
        return ans;
    }
}
