package questions.leetcode132;

public class PalindromePartitioningII {
    public int minCut(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int[][] dp = new int[n][n];

        for (int i=1; i<n; i++) {
            dp[i][i] = 0;
            int temp = dp[0][i-1] + 1;
            for (int j=i-1; j>=0; j--) {
                if (str[j] == str[i] && dp[j+1][i-1] == 0) {
                    dp[j][i] = 0;
                    if (j != 0)
                        temp = Math.min(temp, dp[0][j-1] + 1);
                    else
                        temp = 0;
                } else {
                    dp[j][i] = dp[j+1][i] + 1;
                    if (j != 0)
                        temp = Math.min(temp, dp[0][j-1] + 1 + dp[j][i]);
                    else
                        temp = Math.min(temp, dp[j][i]);
                }
            }
            dp[0][i] = temp;
        }

        return dp[0][n-1];
    }
}
