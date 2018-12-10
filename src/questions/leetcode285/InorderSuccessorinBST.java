package questions.leetcode285;

import questions.dataStructure.TreeNode;

public class InorderSuccessorinBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null)
            return leftMostSearch(p.right);
        return parentSearch(root, p);
    }

    private TreeNode parentSearch(TreeNode curr, TreeNode p) {
        TreeNode ans = null;
        while (curr != p) {
            if (curr.val < p.val)
                curr = curr.right;
            else {
                ans = curr;
                curr = curr.left;
            }
        }
        return ans;
    }

    private TreeNode leftMostSearch(TreeNode p) {
        if (p.left == null)
            return p;
        return leftMostSearch(p.left);
    }
}
