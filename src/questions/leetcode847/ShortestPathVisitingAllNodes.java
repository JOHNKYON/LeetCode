package questions.leetcode847;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<Tuple> queue = new LinkedList<>();
        Set<Tuple> visited = new HashSet<>();

        for (int i=0; i<n; i++) {
            Tuple node = new Tuple(0 | (1 << i), i, 0);
            visited.add(node);
            queue.add(node);
        }
        while (!queue.isEmpty()) {
            Tuple curr = queue.poll();
            if (curr.bitMask == (1 << n) - 1)
                return curr.cost;

            int[] neighbor = graph[curr.curr];
            for (int v: neighbor) {
                int bitMask = curr.bitMask;
                bitMask |= (1 << v);
                Tuple new_node = new Tuple(bitMask, v, curr.cost+1);
                if (!visited.contains(new_node)) {
                    visited.add(new_node);
                    queue.offer(new_node);
                }
            }
        }
        return -1;
    }

    class Tuple {
        int bitMask;
        int curr;
        int cost;

        public Tuple(int bt, int cr, int ct) {
            bitMask = bt;
            curr = cr;
            cost = ct;
        }

        public boolean equals(Object o){
            Tuple p = (Tuple) o;
            return bitMask == p.bitMask && curr == p.curr && cost == p.cost;
        }

        public int hashCode(){
            return 1331 * bitMask + 7193 * curr + 727 * cost;
        }
    }
}
