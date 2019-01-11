package questions.leetcode237;

import questions.dataStructure.ListNode;

public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        while (node.next != null && node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}
