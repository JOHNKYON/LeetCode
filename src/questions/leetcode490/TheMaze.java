package questions.leetcode490;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        final int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        if (maze == null || maze.length == 0 || maze[0].length == 0)
            return false;

        Queue<int[]> candidates = new LinkedList<>();
        candidates.offer(start);
        visited[start[0]][start[1]] = true;
        while(!candidates.isEmpty()) {
            int[] curr = candidates.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1])
                return true;
            for (int[] move: moves) {
                int ni = curr[0] + move[0];
                int nj = curr[1] + move[1];
                while (ni >= 0 && ni < maze.length &&
                        nj >= 0 && nj < maze[0].length &&
                        maze[ni][nj] != 1) {
                    ni += move[0];
                    nj += move[1];
                }
                ni -= move[0];
                nj -= move[1];
                if (!visited[ni][nj]) {
                    visited[ni][nj] = true;
                    candidates.offer(new int[]{ni, nj});
                }
            }
        }

        return false;
    }
}
