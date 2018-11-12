package questions.leetcode650;

public class TwoKeysKeyboard {
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        dp[1] = 0;
        for (int i=2; i<=n; i++) {
            for (int j=2; j<=i; j++) {
                if (i%j == 0) {
                    dp[i] = dp[i/j] + j;
                    break;
                }
            }
        }
        return dp[n];
    }
}
