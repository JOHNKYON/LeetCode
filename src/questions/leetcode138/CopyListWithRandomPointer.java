package questions.leetcode138;

import questions.dataStructure.RandomListNode;

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode curr_ori = head;
        while (curr_ori != null) {
            RandomListNode curr_new = new RandomListNode(curr_ori.label);
            curr_new.next = curr_ori.next;
            curr_ori.next = curr_new;
            curr_ori = curr_new.next;
        }
        curr_ori = head;
        while (curr_ori != null) {
            curr_ori.next.random = (curr_ori.random == null)? null: curr_ori.random.next;
            curr_ori = curr_ori.next.next;
        }
        curr_ori = head;
        RandomListNode new_head = head.next;
        RandomListNode curr_new = new_head;
        while (curr_ori != null) {
            curr_ori.next = curr_new.next;
            curr_new.next = (curr_ori.next == null)? null: curr_ori.next.next;
            curr_ori = curr_ori.next;
            curr_new = curr_new.next;
        }

        return new_head;
    }
}
