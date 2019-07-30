package questions.leetcode1139;

public class Largest1BorderedSquare {
    public int largest1BorderedSquare(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length, m = grid[0].length;
        int[][] horizontal = new int[n][m];
        int[][] vertical = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                horizontal[i][j] = (grid[i][j] == 0)? 0: (j==0)? 1: horizontal[i][j-1] + 1;
                vertical[i][j] = (grid[i][j] == 0)? 0: (i==0)? 1: vertical[i-1][j] + 1;
            }
        }
        // System.out.println(horizontal[0][0]);
        for (int len = Math.min(n, m); len>0; len--) {
            for (int i=0; i<n-len+1; i++) {
                for (int j=0; j<m-len+1; j++) {
                    if (horizontal[i][j+len-1] >=len && horizontal[i+len-1][j+len-1] >= len && vertical[i+len-1][j] >= len && vertical[i+len-1][j+len-1] >= len) {
                        return len * len;
                    }
                }
            }
        }
        return 0;
    }
}
