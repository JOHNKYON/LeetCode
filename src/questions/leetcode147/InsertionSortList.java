package questions.leetcode147;

import questions.dataStructure.ListNode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return head;

        ListNode fake_head = new ListNode(Integer.MIN_VALUE);
        ListNode curr = head;
        ListNode prev = fake_head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            prev = fake_head;
            while (prev.next != null && prev.next.val < curr.val)
                prev = prev.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }
        return fake_head.next;
    }
}
