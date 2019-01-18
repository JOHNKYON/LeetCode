package questions.leetcode876;

import questions.dataStructure.ListNode;

public class MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null)
            return head;
        ListNode slow = head, fast = head;
        while (fast.next !=null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null)
            return slow;
        else
            return slow.next;
    }
}
