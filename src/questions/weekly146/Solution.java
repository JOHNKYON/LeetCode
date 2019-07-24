package questions.weekly146;

public class Solution {
    long[][] sum;
    long[][] largest;
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        sum = new long[n][n];
        largest = new long[n][n];
        long l = 0, r = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int temp = 0;
                for (int k=i; k<=j; k++) {
                    temp = Math.max(arr[k], temp);
                }
                largest[i][j] = temp;
            }
        }
        Long ans = Long.MAX_VALUE;
        ans = Math.min(ans, dp(0, n-1));
        return Math.toIntExact(ans);
    }

    private long dp(int left, int right) {
        if (sum[left][right] != 0) {
            return sum[left][right];
        }
        if (left == right) {
            return 0l;
        }
        if (right == left + 1) {
            sum[left][right] = largest[left][left] * largest[right][right];
        } else {
            long ans = Integer.MAX_VALUE;
            for (int mid=left; mid<right; mid++) {
                long temp = dp(left, mid) + dp(mid+1, right) + largest[left][mid] * largest[mid+1][right];
                ans = Math.min(ans, temp);
            }
            sum[left][right] = ans;
        }
        return sum[left][right];
    }
}
