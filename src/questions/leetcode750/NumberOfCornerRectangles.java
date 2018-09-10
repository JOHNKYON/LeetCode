package questions.leetcode750;

public class NumberOfCornerRectangles {
    public int countCornerRectangles(int[][] grid) {
        int res = 0;

        if (grid.length == 0 || grid[0].length == 0)   return 0;

        int n = grid[0].length;

        int[][] found = new int[n][n];

        for (int[] row:grid){
            for (int left=0; left<n-1; left++) {
                if (row[left] == 0) continue;
                for (int right=left+1; right < n; right++){
                    if (row[right] == 1) {
                        res += found[left][right];
                        found[left][right]++;
                    }
                }
            }
        }

        return res;
    }
}
