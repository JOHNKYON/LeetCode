package questions.leetcode973;

import java.util.Arrays;
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

    int[][] ans;
    public int[][] kClosest2(int[][] points, int K) {
        ans = points;

        work(0, points.length-1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void work(int left, int right, int k) {
        if (left >= right)
            return;

        int ol = left, or = right;
        int pivot = dist((left+right)/2);

        while (left < right) {
            while (left < right && dist(left) < pivot) left++;
            while (left < right && dist(right) > pivot) right--;
            swap(left, right);
        }

        if (k <= left - ol + 1) {
            work(ol, left, k);
        } else {
            work(left+1, or, k - (left - ol + 1));
        }
    }

    private int dist(int i) {
        return ans[i][0] * ans[i][0] + ans[i][1] * ans[i][1];
    }

    private void swap(int a, int b) {
        int t0 = ans[a][0], t1 = ans[a][1];
        ans[a][0] = ans[b][0];
        ans[a][1] = ans[b][1];
        ans[b][0] = t0;
        ans[b][1] = t1;
    }
}
