package questions.leetcode725;

import questions.dataStructure.ListNode;

public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];

        ListNode curr = root;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        int mod = len % k;
        int size = len / k;

        curr = root;
        ListNode prev = null;
        for (int i=0; i<k; i++) {
            if (prev !=null)
                prev.next = null;
            ans[i] = curr;
            for (int j=0; j<size; j++) {
                prev = curr;
                curr = curr.next;
            }
            if (mod > 0) {
                prev = curr;
                curr = curr.next;
                mod--;
            }
        }
        return ans;
    }
}
