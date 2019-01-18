package questions.leetcode86;

import questions.dataStructure.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return head;
        ListNode less = null;
        ListNode greater_head = null;
        ListNode greater_tail = null;
        ListNode curr = head;
        ListNode new_head = head;
        while (curr != null) {
            ListNode next = curr.next;
            if (curr.val < x) {
                // Less
                if (less != null) {
                    less.next = curr;
                } else
                    new_head = curr;
                less = curr;
            } else {
                // Equal or More
                if (greater_head == null) {
                    greater_head = curr;
                    greater_tail = curr;
                } else {
                    greater_tail.next = curr;
                    greater_tail = curr;
                }
            }
            curr = next;
        }
        if (less == null)
            return greater_head;
        less.next = greater_head;
        if (greater_tail != null)
            greater_tail.next = null;
        return new_head;
    }
}
