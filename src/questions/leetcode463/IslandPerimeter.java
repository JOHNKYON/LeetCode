package questions.leetcode463;

public class IslandPerimeter {
    int count;
    int inner;

    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0)   return 0;

        count = 0;
        inner = -1;

        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j] == 1)
                    dp(grid, i, j);
            }
        }

        return count*4 - inner;
    }

    private void dp(int[][] grid, int i, int j){
        if (i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length ||
                grid[i][j] == 0)
            return;
        if (grid[i][j] == 1){
            count++;
            grid[i][j] = -1;
            dp(grid, i-1, j);
            dp(grid, i+1, j);
            dp(grid, i, j-1);
            dp(grid, i, j+1);
        }
        inner++;
    }
}
