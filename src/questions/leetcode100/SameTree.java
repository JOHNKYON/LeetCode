package questions.leetcode100;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameNode(p, q);
    }

    private boolean isSameNode(TreeNode p, TreeNode q){
        if (p==null && q==null) return true;
        if ((p==null && q!=null) || (p!=null && q==null) || p.val != q.val) return false;
        return isSameNode(p.left, q.left) && isSameNode(p.right, q.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
