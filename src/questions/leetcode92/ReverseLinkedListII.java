package questions.leetcode92;

import questions.dataStructure.ListNode;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return head;

        ListNode curr = head, prev = null;
        while (m > 1) {
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }
        ListNode before = prev, tail = curr;
        while (n > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n--;
        }
        if (before != null)
            before.next = prev;
        else
            head = prev;
        tail.next = curr;
        return head;
    }
}
