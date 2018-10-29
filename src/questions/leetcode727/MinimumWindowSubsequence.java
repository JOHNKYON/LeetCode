package questions.leetcode727;

public class MinimumWindowSubsequence {
    public String minWindow(String S, String T) {
        if (S == null || S.length() == 0 ||
                S.length() < T.length() || T == null ||
                T.length() == 0)
            return "";

        int n = S.length(), m = T.length();
        int[][] dp = new int[m][n];

        for (int j=0; j<m; j++) {
            int temp = -1;
            for (int i=0; i<n; i++) {
                dp[j][i] = temp;
                // Len 1
                if (j == 0) {
                    if (S.charAt(i) == T.charAt(j)) {
                        temp = Math.max(temp, i);
                        dp[j][i] = temp;
                    }
                } else {
                    if (i - j >= 0) {
                        if (S.charAt(i) == T.charAt(j)) {
                            temp = Math.max(temp, dp[j - 1][i - 1]);
                            dp[j][i] = temp;
                        }
                    }
                }
            }
        }
        int left = 1, right = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            if (dp[m-1][i] != -1) {
                int len = i - dp[m-1][i] + 1;
                if (len < right - left + 1) {
                    left = dp[m-1][i];
                    right = i;
                }
            }
        }
        return (right < Integer.MAX_VALUE)?S.substring(left, right+1): "";
    }
}
