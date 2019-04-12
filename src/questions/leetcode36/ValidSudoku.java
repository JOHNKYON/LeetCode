package questions.leetcode36;

public class ValidSudoku {
    boolean[][] rows;
    boolean[][] cols;
    boolean[][] grids;
    public boolean isValidSudoku(char[][] board) {
        rows = new boolean[9][9];
        cols = new boolean[9][9];
        grids = new boolean[9][9];
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] != '.') {
                    if (!valid(i, j, board[i][j] - '1'))
                        return false;
                }
            }
        }
        return true;
    }

    private boolean valid(int i, int j, int num) {
        int gridIdx = (i / 3) * 3 + (j / 3);
        if (rows[i][num] || cols[j][num] || grids[gridIdx][num])
            return false;
        rows[i][num] = true;
        cols[j][num] = true;
        grids[gridIdx][num] = true;
        return true;
    }
}
