package questions.leetcode230;

import java.util.Stack;

public class kthSmallestInBST {

    public int kthSmallest(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack<>();

        int count = 0;
        TreeNode cur = root;
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()){
            cur = stack.pop();
            count += 1;

            if (count == k) return cur.val;

            cur = cur.right;
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
        }
        return root.val;
    }

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {val = x;}
    }
}


