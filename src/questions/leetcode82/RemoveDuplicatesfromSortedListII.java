package questions.leetcode82;

import questions.dataStructure.ListNode;

public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head, slow = dummy;
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val)
                fast = fast.next;
            if (slow.next != fast) {
                slow.next = fast.next;
                fast = fast.next;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}
