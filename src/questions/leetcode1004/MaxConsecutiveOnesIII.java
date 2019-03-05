package questions.leetcode1004;

import java.util.Arrays;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int n = A.length;
        int[][] memo = new int[2][n+1];

        for (int j=0; j<=K; j++) {
            for (int i=1; i<=n; i++) {
                if (A[i-1] == 1)
                    memo[1][i] = memo[1][i-1] + 1;
                else {
                    if (j == 0)
                        memo[1][i] = 0;
                    else
                        memo[1][i] = memo[0][i-1] + 1;
                }
            }
            memo[0] = Arrays.copyOf(memo[1], n);
            // System.out.println(Arrays.toString(memo[1]));
        }

        int ans = 0;
        for (int i=1; i<=n; i++) {
            ans = Math.max(ans, memo[1][i]);
        }
        return ans;
    }
}
