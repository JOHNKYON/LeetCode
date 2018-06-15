package questions.leetcode173;

import java.util.Stack;

public class BSTIterator {

    private Stack<TreeNode> path;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public BSTIterator(TreeNode root) {
        TreeNode cur = root;
        path = new Stack<>();
        if (root != null) {
            path.push(cur);
            while (cur.left != null){
                cur = cur.left;
                path.push(cur);
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !path.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = path.pop();
        TreeNode cur = node;

        if (cur.right != null){
            cur = cur.right;
            path.push(cur);
            while (cur.left != null){
                cur = cur.left;
                path.push(cur);
            }
        }

        return node.val;
    }
}
