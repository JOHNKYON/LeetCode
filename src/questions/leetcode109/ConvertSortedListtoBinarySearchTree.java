package questions.leetcode109;

import questions.dataStructure.ListNode;
import questions.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListtoBinarySearchTree {
    List<ListNode> list;
    public TreeNode sortedListToBST(ListNode head) {
        list = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        return buildTree(0, list.size()-1);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(list.get(mid).val);
        root.left = buildTree(left, mid-1);
        root.right = buildTree(mid+1, right);
        return root;
    }
}
