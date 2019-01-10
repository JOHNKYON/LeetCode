package questions.leetcode203;

import questions.dataStructure.ListNode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        while (curr != null && curr.val == val) {
            head = curr.next;
            curr = curr.next;
        }

        ListNode prev = head;
        if (prev == null)
            return head;
        curr = prev.next;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else
                prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
