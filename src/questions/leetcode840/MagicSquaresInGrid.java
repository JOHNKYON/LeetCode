package questions.leetcode840;

public class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3)
            return 0;

        int res = 0;
        for (int i=1; i<grid.length-1; i++){
            for (int j=1; j<grid.length-1; j++)
                if (grid[i][j] == 5)
                    res += checkMagic(grid, i, j);
        }

        return res;
    }

    private int checkMagic(int[][] grid, int i, int j){
        for (int a=-1; a<=1; a++){
            for (int b=-1; b<=1; b++){
                if (grid[i+a][j+b] < 1 || grid[i+a][j+b] > 9)
                    return 0;
            }
        }

        if (grid[i-1][j-1] + grid[i+1][j+1] == 10 &&
                grid[i-1][j+1] + grid[i+1][j-1] == 10 &&
                grid[i][j-1] + grid[i][j+1] == 10 &&
                grid[i-1][j] + grid[i+1][j] == 10 &&
                grid[i-1][j-1] + grid[i-1][j] + grid[i-1][j+1] == 15 &&
                grid[i-1][j-1] + grid[i][j-1] + grid[i+1][j-1] == 15)
            return 1;
        return 0;
    }
}
