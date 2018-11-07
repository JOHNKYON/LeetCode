package questions.leetcode329;

public class LongestIncreasingPathInAMatrix {
    int[][] counts;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int n = matrix.length, m = matrix[0].length;
        counts = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++)
                dfs(matrix, counts, i, j, 1);
        }

        int res = 0;
        for (int[] row: counts)
            for (int count: row)
                res = Math.max(res, count);

        return res;
    }

    private void dfs(int[][] matrix, int[][] counts, int i, int j, int len) {
        if (len <= counts[i][j])
            return;
        else
            counts[i][j] = len;

        int[][] moves = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for (int[] move: moves) {
            int ni = i + move[0];
            int nj = j + move[1];
            if (ni < 0 || ni >= matrix.length || nj < 0 || nj >= matrix[0].length)
                continue;
            if (matrix[ni][nj] > matrix[i][j])
                dfs(matrix, counts, ni, nj, len+1);
        }
        return;
    }
}
