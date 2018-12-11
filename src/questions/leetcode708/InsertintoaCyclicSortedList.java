package questions.leetcode708;

import questions.dataStructure.Node;

public class InsertintoaCyclicSortedList {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node newNode = new Node(insertVal, null);
            newNode.next = newNode;
            return newNode;
        }

        Node node = head;
        boolean start = true;
        while (node != head || start) {
            start = false;
            if (node.val <= insertVal && node.next.val >= insertVal) {
                break;
            } else if (node.val > node.next.val && (insertVal > node.val || node.next.val > insertVal)) {
                break;
            }
            node = node.next;
        }

        Node newNode = new Node(insertVal, node.next);
        node.next = newNode;

        return head;
    }
}
