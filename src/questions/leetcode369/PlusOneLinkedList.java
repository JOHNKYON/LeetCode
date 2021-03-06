package questions.leetcode369;

import questions.dataStructure.ListNode;

import java.util.Stack;

public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        int c = 1;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            curr.val = curr.val + c;
            c = 0;
            if (curr.val >= 10) {
                curr.val -= 10;
                c = 1;
            }
        }
        if (c != 0) {
            ListNode node = new ListNode(c);
            node.next = head;
            head = node;
        }
        return head;
    }

    public ListNode plusOne2(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode left = dummy, right = dummy;
        left.next = right.next = head;
        while (right.next != null) {
            right = right.next;
            if (right.val != 9)
                left = right;
        }
        if (right.val != 9)
            right.val++;
        else {
            left.val++;
            left = left.next;
            while (left != null) {
                left.val = 0;
                left = left.next;
            }
        }
        return dummy.val == 1? dummy: head;
    }
}
