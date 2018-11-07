package questions.leetcode329;

import java.util.ArrayList;
import java.util.List;

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

    private static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;
    public int longestIncreasingPath2(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        // padding the matrix with zero as boundaries
        // assuming all positive integer, otherwise use INT_MIN as boundaries
        int[][] matrix = new int[m + 2][n + 2];
        for (int i = 0; i < m; ++i)
            System.arraycopy(grid[i], 0, matrix[i + 1], 1, n);

        // calculate outdegrees
        int[][] outdegree = new int[m + 2][n + 2];
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                for (int[] d: dir)
                    if (matrix[i][j] < matrix[i + d[0]][j + d[1]])
                        outdegree[i][j]++;

        // find leaves who have zero out degree as the initial level
        n += 2;
        m += 2;
        List<int[]> leaves = new ArrayList<>();
        for (int i = 1; i < m - 1; ++i)
            for (int j = 1; j < n - 1; ++j)
                if (outdegree[i][j] == 0) leaves.add(new int[]{i, j});

        // remove leaves level by level in topological order
        int height = 0;
        while (!leaves.isEmpty()) {
            height++;
            List<int[]> newLeaves = new ArrayList<>();
            for (int[] node : leaves) {
                for (int[] d:dir) {
                    int x = node[0] + d[0], y = node[1] + d[1];
                    if (matrix[node[0]][node[1]] > matrix[x][y])
                        if (--outdegree[x][y] == 0)
                            newLeaves.add(new int[]{x, y});
                }
            }
            leaves = newLeaves;
        }
        return height;
    }
}
