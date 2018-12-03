package questions.leetcode378;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0)
            return 0;
        Queue<Integer> heap = new PriorityQueue<>();
        for (int[] row: matrix) {
            for (int ele: row)
                heap.offer(ele);
        }

        while(k-- > 1) {
            heap.poll();
        }
        return heap.poll();
    }
}
