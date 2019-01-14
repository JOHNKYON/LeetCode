package questions.leetcode83;

import questions.dataStructure.ListNode;

import java.util.HashSet;

public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        HashSet<Integer> set = new HashSet<>();
        ListNode prev = head;
        ListNode next = prev.next;
        set.add(prev.val);

        while (next != null) {
            if (set.contains(next.val)) {
                prev.next = next.next;
            } else {
                set.add(next.val);
                prev = next;
            }
            next = next.next;
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null)
            return head;
        ListNode prev = head;
        ListNode next = prev.next;

        while (next != null) {
            if (prev.val == next.val) {
                prev.next = next.next;
            } else {
                prev = next;
            }
            next = next.next;
        }
        return head;
    }
}
