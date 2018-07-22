package questions.leetcode142;

import questions.dataStructure.ListNode;

public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)   return null;

        ListNode step1 = head.next;
        ListNode step2 = head.next.next;

        while(step1 != step2){
            if (step2==null || step2.next==null)    return null;

            step1 = step1.next;
            step2 = step2.next.next;
        }

        while (head != step1){
            head = head.next;
            step1 = step1.next;
        }

        return head;
    }
}
