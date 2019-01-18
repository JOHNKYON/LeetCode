package questions.leetcode445;

import questions.dataStructure.ListNode;

import java.util.Stack;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        Stack<ListNode> sa = new Stack<>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        } while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        int n = 0, c = 0;
        int n1, n2;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            n1 = 0;
            n2 = 0;
            if (!s1.isEmpty())
                n1 = s1.pop().val;
            if (!s2.isEmpty())
                n2 = s2.pop().val;
            n = n1 + n2 + c;
            if (n >= 10) {
                n -= 10;
                c = 1;
            } else
                c = 0;
            sa.push(new ListNode(n));
        }
        if (c != 0)
            sa.push(new ListNode(c));
        ListNode head;
        if (sa.isEmpty())
            head = new ListNode(0);
        else
            head = sa.pop();
        ListNode curr = head;
        while(!sa.isEmpty()) {
            ListNode next = sa.pop();
            curr.next = next;
            curr = next;
        }
        return head;
    }
}
