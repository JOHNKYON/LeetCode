package questions.leetcode61;

import questions.dataStructure.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null)
            return head;
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        k = k % len;
        ListNode new_tail = head;
        ListNode pioneer = head;
        while (k-- > 0)
            pioneer = pioneer.next;
        while (pioneer.next != null) {
            new_tail = new_tail.next;
            pioneer = pioneer.next;
        }
        pioneer.next = head;
        ListNode new_head = new_tail.next;
        new_tail.next = null;
        return new_head;
    }
}
