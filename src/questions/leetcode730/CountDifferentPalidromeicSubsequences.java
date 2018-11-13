package questions.leetcode730;

public class CountDifferentPalidromeicSubsequences {
    public int countPalindromicSubsequences(String S) {
        if (S == null || S.length() == 0)
            return 0;
        int n = S.length();
        int[][][] dp = new int[4][n][n];
        int mod = 1000000007;

        for (int i=n-1; i>=0; i--) {
            for (int j=i; j<n; j++) {
                for (int x=0; x<4; x++) {
                    if (j == i) {
                        if (S.charAt(i) == 'a' + x)
                            dp[x][i][j] = 1;
                        else
                            dp[x][i][j] = 0;
                    } else {
                        // j > i
                        if (S.charAt(i) != 'a' + x)
                            dp[x][i][j] = dp[x][i+1][j];
                        else if (S.charAt(j) != 'a' + x)
                            dp[x][i][j] = dp[x][i][j-1];
                        else {
                            if (i == j - 1)
                                dp[x][i][j] = 2;
                            else {
                                dp[x][i][j] = 2;
                                for (int m=0; m<4; m++) {
                                    dp[x][i][j] += dp[m][i+1][j-1];
                                    dp[x][i][j] %= 1000000007;
                                }
                            }
                        }
                    }
                }
            }
        }

        int res = 0;
        for (int x=0; x<4; x++) {
            res += dp[x][0][n-1];
            res %= mod;
        }
        return res;
    }
}
