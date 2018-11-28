package questions.leetcode668;

public class KthSmallestNumberInMultiplicationTable {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1;
        int hi = m*n;
        while (lo < hi) {
            int mi = lo + (hi - lo)/2;
            if (!enough(m, n, k, mi))
                lo = mi+1;
            else
                hi = mi;
        }
        return lo;
    }

    private boolean enough(int m, int n, int k, int x) {
        int count = 0;
        for (int i=1; i<=m && i <= x; i++) {
            count += Math.min(x / i, n);
        }

        return count >= k;
    }
}
