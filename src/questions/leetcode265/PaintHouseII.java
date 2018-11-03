package questions.leetcode265;

public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0)
            return 0;
        int n = costs.length;
        int k = costs[0].length;

        int[][] dp = new int[n][k];
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int pos = -1;
        for (int i=0; i<n; i++) {
            int min_line = Integer.MAX_VALUE;
            int min_line2 = Integer.MAX_VALUE;
            int pos_line = -1;
            for (int j=0; j<k; j++) {
                if (i == 0) {
                    dp[i][j] = costs[i][j];
                    if (dp[i][j] < min_line) {
                        min_line2 = min_line;
                        min_line = dp[i][j];
                        pos_line = j;
                    } else {
                        min_line2 = Math.min(min_line2, dp[i][j]);
                    }
                } else {
                    if (j != pos) {
                        dp[i][j] = min + costs[i][j];
                    } else {
                        dp[i][j] = min2 + costs[i][j];
                    }
                    if (dp[i][j] < min_line) {
                        min_line2 = min_line;
                        min_line = dp[i][j];
                        pos_line = j;
                    } else {
                        min_line2 = Math.min(min_line2, dp[i][j]);
                    }
                }
            }
            min = min_line;
            min2 = min_line2;
            pos = pos_line;
        }

        return min;
    }
}
