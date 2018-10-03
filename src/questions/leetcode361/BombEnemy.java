package questions.leetcode361;

public class BombEnemy {
    int max;

    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        max = 0;
        int[][] count = new int[grid.length][grid[0].length];

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 'E')
                    modify(grid, count, i, j);
            }
        }

        return max;
    }

    private void modify(char[][] grid, int[][] count, int row, int col) {
        for (int i = col; i>=0 && grid[row][i]!='W'; i--) {
            if (grid[row][i] == '0')
                max = Math.max(max, ++count[row][i]);
        }
        for (int i = col+1; i<grid[row].length && grid[row][i]!='W'; i++) {
            if (grid[row][i] == '0')
                max = Math.max(max, ++count[row][i]);
        }

        for (int i = row; i>=0 && grid[i][col] != 'W'; i--) {
            if (grid[i][col] == '0')
                max = Math.max(max, ++count[i][col]);
        }

        for (int i = row+1; i<grid.length && grid[i][col] != 'W'; i++) {
            if (grid[i][col] == '0')
                max = Math.max(max, ++count[i][col]);
        }
    }
}
