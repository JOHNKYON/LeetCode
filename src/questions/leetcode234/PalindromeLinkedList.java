package questions.leetcode234;

import questions.dataStructure.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode ptr = head;
        while(ptr != null){
            stack.push(ptr);
            ptr = ptr.next;
        }

        ptr = head;
        while(ptr != null){
            if (ptr.val != stack.pop().val) return false;
            ptr = ptr.next;
        }

        return true;
    }
}
