package questions.leetcode24;

import questions.dataStructure.ListNode;

public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;
        if (head != null && head.next != null) {
            ListNode next = head.next;
            head.next = swapPairs(next.next);
            next.next = head;
            return next;
        }
        return head;
    }
}
