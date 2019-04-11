package questions.leetcode59;

public class SpiralMatrixII {
    final static int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[][] generateMatrix(int n) {
        int curr = 0;
        int goal = n * n;
        int[][] matrix = new int[n][n];
        // int top = 0, left = 0, right = n-1, down = n-1;
        int[] borders = new int[4]; // right, down, left, up;
        borders[0] = n-1; borders[1] = n-1; borders[3] = 1;
        int r = 0, c = 0;
        int dir = 0;
        while (curr < goal) {
            matrix[r][c] = ++curr;
            r = r + moves[dir][0]; c = c + moves[dir][1];
            if (dir == 0) {
                if (c == borders[dir]) {
                    borders[dir]--;
                    dir = (dir + 1) % 4;
                }
            } else if (dir == 1) {
                if (r == borders[dir]) {
                    borders[dir]--;
                    dir = (dir + 1) % 4;
                }
            } else if (dir == 2) {
                if (c == borders[dir]) {
                    borders[dir]++;
                    dir = (dir + 1) % 4;
                }
            } else {
                if (r == borders[dir]) {
                    borders[dir]++;
                    dir = (dir + 1) % 4;
                }
            }
        }
        return matrix;
    }
}
