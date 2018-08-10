package questions.leetcode572;

import questions.dataStructure.TreeNode;

public class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null)    return false;
        if (check(s, t))    return true;

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean check(TreeNode node, TreeNode t){
        if (node == null && t == null)  return true;

        if ((node == null && t!=null) || (t==null && node!=null)
                || node.val != t.val)
            return false;

        return check(node.left, t.left) && check(node.right, t.right);
    }
}
