package questions.leetcode516;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int right=0; right<dp.length; right++) {
            dp[right][right] = 1;
            for (int left = right-1; left >= 0; left--) {
                if (s.charAt(left) == s.charAt(right)) {
                    dp[left][right] = dp[left+1][right-1] + 2;
                } else {
                    dp[left][right] = Math.max(dp[left+1][right], dp[left][right-1]);
                }
            }
        }

        return dp[0][dp.length-1];
    }
}
