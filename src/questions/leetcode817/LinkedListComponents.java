package questions.leetcode817;

import questions.dataStructure.ListNode;

import java.util.HashSet;

public class LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;

        for (int num:G) set.add(num);

        while (head != null) {
            if (set.contains(head.val) &&
                    (head.next == null || !set.contains(head.next.val)))
                ans += 1;
            head = head.next;
        }
        return ans;
    }
}
