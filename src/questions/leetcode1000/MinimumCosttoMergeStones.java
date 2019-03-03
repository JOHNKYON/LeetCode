package questions.leetcode1000;

public class MinimumCosttoMergeStones {
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if (n==0 || (n-1) % (K-1) != 0)
            return -1;

        int[][][] memo = new int[n+1][n+1][K+1];
        int[] prefix = new int[n+1];
        for (int i=1; i<=n; i++)
            prefix[i] = prefix[i-1] + stones[i-1];

        int max = 99999999;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                for (int k=1; k<=K; k++) {
                    memo[i][j][k] = max;
                }
            }
        }

        for (int i=0; i<=n; i++)
            memo[i][i][1] = 0;

        for (int len=2; len <=n; len++) {
            for (int i=1; i <= n-len+1; i++) {
                int j = i + len - 1;
                for (int k=2; k<=K; k++) {
                    for (int t=i; t<j; t++) {
                        memo[i][j][k] = Math.min(memo[i][j][k], memo[i][t][1] + memo[t+1][j][k-1]);
                    }
                }

                memo[i][j][1] = memo[i][j][K] + prefix[j] - prefix[i-1];
            }
        }
        return memo[1][n][1];
    }
}
