package questions.leetcode317;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;

        int n = grid.length;
        int m = grid[0].length;

        int[][] distances = new int[n][m];
        int[][] visited_count = new int[n][m];
        int house_count = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 1)
                    house_count++;
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 1)
                    if (!lee(grid, distances, i, j, house_count, visited_count))
                        return -1;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 0 && visited_count[i][j] == house_count)
                    res = Math.min(res, distances[i][j]);
            }
        }
        return res;
    }

    private boolean lee(int[][] grid, int[][] distances, int i, int j, int house_count, int[][] visited_count) {
        int n = grid.length, m = grid[0].length;
        int[][] visited = new int[n][m];

        Queue<int[]> list = new LinkedList<>();
        list.offer(new int[]{i, j});
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        distances[i][j] = 0;
        int houses = 0;

        while (!list.isEmpty()) {
            int[] curr = list.poll();
            for (int x=0; x<dx.length; x++) {
                int nx = curr[0] + dx[x];
                int ny = curr[1] + dy[x];
                if (nx >= 0 && nx < n && ny >=0 && ny < m && visited[nx][ny] == 0) {
                    if (grid[nx][ny] == 0) {
                        visited[nx][ny] = visited[curr[0]][curr[1]] + 1;
                        distances[nx][ny] += visited[nx][ny];
                        list.offer(new int[]{nx, ny});
                        visited_count[nx][ny]++;
                    } else if (grid[nx][ny] == 1) {
                        houses++;
                        visited[nx][ny] = 1;
                    }
                }
            }
        }

        return houses == house_count;
    }
}
