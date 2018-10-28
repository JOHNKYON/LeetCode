package questions.leetcode931;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0)
            return 0;

        int n = A.length;
        int m = A[0].length;

        int[][] dp = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (i == 0) {
                    dp[i][j] = A[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + A[i][j];
                } else if (j == m-1) {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + A[i][j];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i-1][j+1]) + A[i][j];
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j=0; j<m; j++) {
            res = Math.min(dp[n-1][j], res);
        }
        return res;
    }
}
