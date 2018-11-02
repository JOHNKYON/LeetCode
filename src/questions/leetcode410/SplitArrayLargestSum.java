package questions.leetcode410;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;

        int[][] dp = new int[n+1][m+1];
        int[] sum = new int[n+1];
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i=1; i<=n; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }

        dp[0][0] = 0;
        for (int j=1; j<=m; j++) {
            for (int i=1; i<=n; i++) {
                for (int k=0; k<i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1], sum[i] - sum[k]));
                }
            }
        }
        return dp[n][m];
    }
}
