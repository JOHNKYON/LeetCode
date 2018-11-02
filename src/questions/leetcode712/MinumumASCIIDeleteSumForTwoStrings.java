package questions.leetcode712;

public class MinumumASCIIDeleteSumForTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i=0; i<=n; i++) {
            for (int j=0; j<=m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1] + s2.charAt(j-1);
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] + s1.charAt(i-1);
                } else {
                    if (s1.charAt(i-1) == s2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    }  else {
                        dp[i][j] = Math.min(dp[i-1][j] + s1.charAt(i-1),
                                dp[i][j-1] + s2.charAt(j-1));
                    }
                }
            }
        }
        return dp[n][m];
    }
}
