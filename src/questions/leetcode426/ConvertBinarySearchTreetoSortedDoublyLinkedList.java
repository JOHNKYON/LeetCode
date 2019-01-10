package questions.leetcode426;

import questions.dataStructure.TreeNode;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList {
    TreeNode prev = null;
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        TreeNode dummy = new TreeNode(0);
        prev = dummy;
        helper(root);
        //connect head and tail
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }

    private void helper (TreeNode cur) {
        if (cur == null) return;
        helper(cur.left);
        prev.right = cur;
        cur.left = prev;
        prev = cur;
        helper(cur.right);
    }
}
