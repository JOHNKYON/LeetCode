package questions.leetcode646;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0)
            return 0;

        Arrays.sort(pairs, (a, b) -> a[0]-b[0]);
        int n = pairs.length;
        int[] dp = new int[n];
        int res = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (pairs[i][0] > pairs[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }

        return res+1;
    }

    public int findLongestChain2(int[][] pairs) {
        if (pairs == null || pairs.length == 0)
            return 0;

        Arrays.sort(pairs, (a, b) -> a[1]-b[1]);
        int curr = Integer.MIN_VALUE, ans = 0;
        for (int[] pair: pairs) {
            if (curr < pair[0]) {
                curr = pair[1];
                ans++;
            }
        }

        return ans;
    }
}
