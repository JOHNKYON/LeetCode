package questions.leetcode64;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int res = 0;

        if (grid.length == 0)   return 0;

        int n = grid.length;
        int m = grid[0].length;

        for (int i=0; i<n;i++){
            for (int j=0; j<m; j++){
                if (i == 0 && j == 0)   continue;
                else if (i == 0)
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                else if (j == 0)
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                else {
                    // grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
                    grid[i][j] += (grid[i-1][j]<grid[i][j-1])? grid[i-1][j] : grid[i][j-1];
                }
            }
        }
        res = grid[n-1][m-1];

        return res;
    }
}
