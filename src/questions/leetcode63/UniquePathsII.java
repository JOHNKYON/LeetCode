package questions.leetcode63;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (obstacleGrid[i][j] == 1)
                    continue;
                if (i == 0 && j == 0)
                    dp[i][j] = 1;
                else {
                    if (i == 0)
                        dp[i][j] = dp[i][j-1];
                    else if (j == 0)
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[n-1][m-1];
    }
}
