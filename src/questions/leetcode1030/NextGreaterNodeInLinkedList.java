package questions.leetcode1030;

import questions.dataStructure.ListNode;

import java.util.TreeSet;

public class NextGreaterNodeInLinkedList {
    int[] values;
    int n;
    public int[] nextLargerNodes(ListNode head) {
        return findNext(head, 0);
    }

    private int[] findNext(ListNode node, int len) {
        if (node == null) {
            int[] ans = new int[len];
            values = new int[len];
            n = len;
            return ans;
        } else {
            int[] ans = findNext(node.next, len+1);
            for (int i=len+1; i<n; i++) {
                if (values[i] > node.val) {
                    ans[len] = values[i];
                    break;
                }
            }
            values[len] = node.val;
            return ans;
        }
    }
}
