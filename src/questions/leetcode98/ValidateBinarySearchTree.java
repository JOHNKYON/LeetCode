package questions.leetcode98;
import java.util.Stack;

public class ValidateBinarySearchTree {
        public boolean isValidBST(TreeNode root) {
        if (root == null)   return true;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        TreeNode temp = stack.pop();
        int a = temp.val;
        curr = temp.right;

        while(!stack.isEmpty() || curr != null){
            if (curr == null){
                temp = stack.pop();
                if (a >= temp.val) return false;
                a = temp.val;
                curr = temp.right;
            } else {
                while(curr != null){
                    stack.push(curr);
                    curr = curr.left;
                }
            }
        }
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
