package questions.leetcode264;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        dp[0] = 1;
        for (int i=1; i<n; i++) {
            int min = Math.min(factor2, Math.min(factor3, factor5));
            dp[i] = min;
            if (min == factor2)
                factor2 = 2 * dp[++index2];
            if (min == factor3)
                factor3 = 3 * dp[++index3];
            if (min == factor5)
                factor5 = 5 * dp[++index5];
        }
        return dp[n-1];
    }
}
