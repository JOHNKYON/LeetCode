package questions.leetcode328;

import questions.dataStructure.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return head;

        ListNode even = head;
        ListNode odd = head.next;
        ListNode o_head = odd;
        ListNode e_next, o_next;

        while (even != null && odd != null) {
            e_next = odd.next;
            if (e_next == null)
                break;
            o_next = e_next.next;
            even.next = e_next;
            odd.next = o_next;
            even = e_next;
            odd = o_next;
        }
        even.next = o_head;
        return head;
    }
}
