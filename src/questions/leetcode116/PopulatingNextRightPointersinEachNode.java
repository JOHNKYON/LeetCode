package questions.leetcode116;

import questions.dataStructure.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        Node prev = null;
        queue.offer(root);
        int size = 1;
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            size--;
            curr.next = prev;
            prev = curr;
            if (curr.right != null)
                queue.offer(curr.right);
            if (curr.left != null)
                queue.offer(curr.left);

            if (size == 0) {
                size = queue.size();
                prev = null;
            }
        }
        return root;
    }

    class Node {
        Node left;
        Node right;
        Node next;
        int val;
        public Node(int _val) {
            val = _val;
        }
    }
}
