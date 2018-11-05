package questions.leetcode813;

public class LargestSumOfAverages {
    public double largestSumOfAverages(int[] A, int K) {
        if (A == null || A.length == 0)
            return 0.0;

        int n = A.length;
        double[][] dp = new double[n+1][K+1];
        double[] subsum = new double[n+1];
        for (int i=1; i<=n; i++) {
            subsum[i] = subsum[i-1] + A[i-1];
            dp[i][1] = subsum[i] / i;
        }

        for (int i=1; i<=n; i++) {
            for (int j=2; j<=K; j++) {
                double temp = 0;
                for (int m = j-1; m<i; m++) {
                    temp = Math.max(temp, dp[m][j-1] + (subsum[i]-subsum[m])/(i-m));
                }
                dp[i][j] = temp;
            }
        }

        return dp[n][K];
    }
}
