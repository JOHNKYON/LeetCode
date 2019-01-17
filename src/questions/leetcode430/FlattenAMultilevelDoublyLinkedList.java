package questions.leetcode430;

public class FlattenAMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    };

    public Node flatten(Node head) {
        if (head == null)
            return head;

        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                curr.next = squash(curr, curr.child, curr.next);
                curr.child = null;
            }
            curr = curr.next;
        }
        return head;
    }

    private Node squash(Node parent, Node head, Node next) {
        head.prev = parent;
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                curr.next = squash(curr, curr.child, curr.next);
                curr.child = null;
            }
            prev = curr;
            curr = curr.next;
        }
        prev.next = next;
        if (next != null)
            next.prev = prev;
        return head;
    }
}
