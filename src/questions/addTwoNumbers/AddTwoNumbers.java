package questions.addTwoNumbers;

/**
 * Created by JOHNKYON on 2018/3/8.
 * This is a solution to LeetCode Questions.
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.next != null || l2.next != null){
            if (l1.next == null){l1.next = new ListNode(0);}
            if (l2.next == null){l2.next = new ListNode(0);}

            l1.val += l2.val;
            if (l1.val >= 10) { l1.val -= 10; l1.next.val += 1;}
            addTwoNumbers(l1.next, l2.next);
        } else {
            l1.val += l2.val;
            if (l1.val >= 10) {
                l1.val -= 10;
                l1.next = new ListNode(1);
            }
        }
        return l1;
    }

/*    private ListNode setDigits(int digit, ListNode lastNode){
        return lastNode.next = new ListNode(digit);
    }*/

    public ListNode buildTestData(int[] digits){
        ListNode node = new ListNode(0);
        ListNode head = node;
        node.val = digits[0];
        for (int i = 1; i < digits.length; i++){
//            ListNode node = setDigits(digits[i], node);
            node.next = new ListNode(digits[i]);
            node = node.next;
        }
        return head;
    }

    public void printList(ListNode node){
        System.out.print(node.val);
        if (node.next != null) {
            printList(node.next);
        }
    }
}
