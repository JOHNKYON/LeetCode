package questions.leetcode286;

import java.util.LinkedList;
import java.util.Queue;

public class WallsandGates {
    final static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0)
            return;
        for (int i=0; i<rooms.length; i++) {
            for (int j=0; j<rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                }
            }
        }
        return;
    }

    private void bfs(int[][] rooms, int i, int j) {
        Queue<int[]> candidates = new LinkedList<>();
        candidates.offer(new int[]{i, j});
        int step = 1;
        int size = 1;
        while (!candidates.isEmpty()) {
            if (size == 0) {
                step++;
                size = candidates.size();
            }
            int[] curr = candidates.poll();
            for (int[] move: moves) {
                int nx = curr[0] + move[0];
                int ny = curr[1] + move[1];
                if (nx >= 0 && nx < rooms.length &&
                        ny >= 0 && ny < rooms[0].length &&
                        rooms[nx][ny] > step) {
                    rooms[nx][ny] = step;
                    candidates.offer(new int[]{nx, ny});
                }
            }
            size--;
        }
    }
}
