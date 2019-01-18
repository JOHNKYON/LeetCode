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

    public Node flatten2(Node head) {
        if( head == null) return head;
        // Pointer
        Node p = head;
        while( p!= null) {
            /* CASE 1: if no child, proceed */
            if( p.child == null ) {
                p = p.next;
                continue;
            }
            /* CASE 2: got child, find the tail of the child and link it to p.next */
            Node temp = p.child;
            // Find the tail of the child
            while( temp.next != null )
                temp = temp.next;
            // Connect tail with p.next, if it is not null
            temp.next = p.next;
            if( p.next != null )  p.next.prev = temp;
            // Connect p with p.child, and remove p.child
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
}
