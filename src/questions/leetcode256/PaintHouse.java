package questions.leetcode256;

public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0)
            return 0;

        int n = costs.length;
        int[][] dp = new int[n][3];
        for (int i=0; i<n; i++) {
            if (i == 0) {
                dp[i][0] = costs[i][0];
                dp[i][1] = costs[i][1];
                dp[i][2] = costs[i][2];
            }
            else for (int j=0; j<3; j++) {
                dp[i][j] = Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + costs[i][j];
            }
        }
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }
}
