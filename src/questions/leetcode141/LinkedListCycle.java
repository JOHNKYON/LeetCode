package questions.leetcode141;

import questions.dataStructure.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode curr = head;

        while(curr != null){
            if (curr.next == head)  return true;

            ListNode pre = curr;
            curr = curr.next;
            pre.next = head;
        }
        return false;
    }
}
