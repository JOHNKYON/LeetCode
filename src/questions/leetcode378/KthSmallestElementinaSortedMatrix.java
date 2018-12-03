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

    public int kthSmallestII(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n-1][n-1];
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (enough(matrix, mid, k))
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return lo;
    }

    private boolean enough(int[][] matrix, int mid, int k) {
        int n = matrix.length;
        int i = n-1, j = 0;
        int count = 0;
        while (i >=0 && j < n) {
            if (matrix[i][j] <= mid) {
                count += i+1;
                j++;
            } else
                i--;
            if (count >= k)
                return true;
        }
        return false;
    }
}
