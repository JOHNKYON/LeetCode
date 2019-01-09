package questions.leetcode695;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int ans = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {
        int[][] steps = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        if (i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length ||
                grid[i][j] == 0)
            return 0;

        grid[i][j] = 0;
        int count = 1;
        for (int[] step : steps) {
            count += dfs(grid, i+step[0], j+step[1]);
        }
        return count;
    }
}
