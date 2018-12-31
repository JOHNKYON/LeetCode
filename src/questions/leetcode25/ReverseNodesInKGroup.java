package questions.leetcode25;

import questions.dataStructure.ListNode;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode curr = head;
        for (int i=0; i<k; i++) {
            if (curr == null)
                return head;
            curr = curr.next;
        }
        ListNode[] head_tail = reverse(head, curr);
        head_tail[1].next = reverseKGroup(curr, k);
        return head_tail[0];
    }

    private ListNode[] reverse(ListNode head, ListNode next) {
        if (head.next == next) {
            ListNode[] head_tail = new ListNode[2];
            head_tail[0] = head;
            head_tail[1] = head;
            return head_tail;
        }
        ListNode[] head_tail = reverse(head.next, next);
        head.next.next = head;
        head.next = head_tail[0];
        head_tail[1] = head;
        return head_tail;
    }
}
