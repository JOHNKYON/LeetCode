package questions.leetcode773;

import java.util.*;

public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        HashSet<String> visited = new HashSet<>();
        Queue<int[][]> candidates = new LinkedList<>();
        candidates.offer(board);
        int move = 0;
        int left = 1;
        while (!candidates.isEmpty()) {
            if (left == 0) {
                left = candidates.size();
                move++;
            }
            int[][] candidate = candidates.poll();
            left--;
            if (valid(candidate))
                return move;
            for (int[][] next: oneStep(candidate)) {
                String key = keyGen(next);
                if (!visited.contains(key)) {
                    candidates.offer(next);
                    visited.add(key);
                }
            }
        }
        return -1;
    }

    private boolean valid(int[][] candidate) {
        for (int i=0; i<3; i++)
            if (candidate[0][i] != i+1)
                return false;
        for (int i=0; i<2; i++)
            if (candidate[1][i] != i+4)
                return false;
        return candidate[1][2] == 0;
    }

    private List<int[][]> oneStep(int[][] candidate) {
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        List<int[][]> res = new ArrayList<>();
        int x = 0, y = 0;
        for (int i=0; i<2; i++) {
            for (int j=0; j<3; j++) {
                if (candidate[i][j] == 0) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        for (int[] move: moves) {
            int nx = x+move[0];
            int ny = y+move[1];
            if (nx >= 0 && nx < 2 && ny >= 0 && ny < 3) {
                int[][] ngrid = new int[][] {{candidate[0][0], candidate[0][1], candidate[0][2]},
                        {candidate[1][0], candidate[1][1], candidate[1][2]}};
                int temp = ngrid[x][y];
                ngrid[x][y] = ngrid[nx][ny];
                ngrid[nx][ny] = temp;
                res.add(ngrid);
            }
        }
        return res;
    }

    private String keyGen(int[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<2; i++) {
            for (int j=0; j<3; j++) {
                sb.append(grid[i][j]);
            }
        }
        return sb.toString();
    }
}
