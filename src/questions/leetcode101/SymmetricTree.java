package questions.leetcode101;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)   return true;

        return mirrorNode(root.left, root.right);
    }

    public boolean mirrorNode(TreeNode p, TreeNode q){
        if (p == null && q==null)   return true;
        if ((p==null && q!=null) || (p!=null && q==null) || p.val!=q.val)   return false;
        return mirrorNode(p.left, q.right) && mirrorNode(p.right, q.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
