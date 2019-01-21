package questions.leetcode973;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];

        Queue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] * a[0] - b[0] * b[0]  + a[1] * a[1] - b[1] * b[1];
            }
        });

        for (int[] point: points) {
            heap.offer(point);
        }
        for (int i=0; i<K; i++) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}
