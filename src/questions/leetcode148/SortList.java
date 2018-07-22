package questions.leetcode148;

import questions.dataStructure.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head==null || head.next == null)    return head;

        ListNode step1 = head;
        ListNode step2 = head;
        ListNode prev = null;

        while(step2!=null && step2.next!=null){
            prev = step1;
            step1 = step1.next;
            step2= step2.next.next;
        }

        prev.next = null;

        ListNode list1 = sortList(head);
        ListNode list2 = sortList(step1);

        return mergeList(list1, list2);
    }

    private ListNode mergeList(ListNode list1, ListNode list2){
        ListNode head = new ListNode(0);
        ListNode curr = head;

        while(list1 != null && list2 != null){
            if (list1.val >= list2.val){
                curr.next = list2;
                list2 = list2.next;
            } else {
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }
        if (list1 != null){
            curr.next = list1;
        } else if (list2 != null){
            curr.next = list2;
        }

        return head.next;
    }
}
