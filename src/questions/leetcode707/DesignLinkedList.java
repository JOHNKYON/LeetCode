package questions.leetcode707;

public class DesignLinkedList {
    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int i) {
            val = i;
            next = null;
            prev = null;
        }
    }

    Node head;
    Node tail;

    /** Initialize your data structure here. */
    public DesignLinkedList() {
        head = null;
        tail = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node curr = head;
        while (curr != null && index-- > 0) {
            curr = curr.next;
        }
        return curr == null? -1 : curr.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node n_node = new Node(val);
        if (head == null) {
            head = n_node;
            tail = n_node;
        } else {
            n_node.next = head;
            head.prev = n_node;
            head = n_node;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node n_node = new Node(val);
        if (head == null) {
            head = n_node;
            tail = n_node;
        } else {
            tail.next = n_node;
            n_node.prev = tail;
            tail = n_node;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node curr = head;
        while (curr != null && index-- > 1) {
            curr = curr.next;
        }
        if (curr != null) {
            Node n = new Node(val);
            if (curr.next != null) {
                curr.next.prev = n;
                n.next = curr.next;
            } else {
                tail = n;
            }
            curr.next = n;
            n.prev = curr;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node curr = head;
        Node prev = null;
        while (curr != null && index-- > 0) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            if (prev == null) {
                head = curr.next;
            }
            else
                prev.next = curr.next;
            if (curr.next != null) {
                curr.next.prev = prev;
            } else
                tail = prev;
            curr.next = null;
            curr.prev = null;
        }
    }
}
