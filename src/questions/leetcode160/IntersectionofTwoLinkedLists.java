package questions.leetcode160;

import questions.dataStructure.ListNode;

public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1 = 0;
        int count2 = 0;

        ListNode curr1 = headA;
        ListNode curr2 = headB;

        while(curr1 != null){
            curr1 = curr1.next;
            count1 += 1;
        }

        while(curr2 != null){
            curr2 = curr2.next;
            count2 += 1;
        }
        curr1 = headA;
        curr2 = headB;

        if (count1 > count2){
            int count = count1-count2;
            while(count > 0){
                curr1=curr1.next;
                count--;
            }
        } else{
            int count = count2 - count1;
            while(count > 0){
                curr2=curr2.next;
                count--;
            }
        }

        while (curr1 != curr2){
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return curr1;
    }
}
