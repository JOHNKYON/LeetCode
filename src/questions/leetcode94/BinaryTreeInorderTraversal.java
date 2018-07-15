package questions.leetcode94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        List<Integer> res = new ArrayList<>();
        if(root == null)    return res;

        stack.push(root);
        TreeNode curr = root.left;
        while(!stack.isEmpty() || curr!=null){
            if (curr == null){
                TreeNode temp = stack.pop();
                res.add(temp.val);
                curr = temp.right;
            } else{
                stack.push(curr);
                curr = curr.left;
            }
        }

        return res;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
