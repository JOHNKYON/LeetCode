package questions.leetcode37;

import java.util.HashSet;

public class SudokuSolver {
    HashSet<Integer>[] columns;
    HashSet<Integer>[] rows;
    HashSet<Integer>[] grids;
    public void solveSudoku(char[][] board) {
        columns = new HashSet[9];
        rows = new HashSet[9];
        grids = new HashSet[9];
        for (int i=0; i<9; i++) {
            columns[i] = new HashSet<>();
            rows[i] = new HashSet<>();
            grids[i] = new HashSet<>();
        }

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rows[i].add(num);
                    columns[j].add(num);
                    grids[(i/3)*3 + j/3].add(num);
                }
            }
        }

        fill(board);
    }

    private boolean fill(char[][] board) {
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] == '.') {
                    for (int num =1; num<=9; num++) {
                        if (!rows[i].contains(num) &&
                                !columns[j].contains(num) &&
                                !grids[(i/3)*3 + j/3].contains(num)) {
                            board[i][j] = (char)('0' + num);
                            rows[i].add(num);
                            columns[j].add(num);
                            grids[(i/3)*3 + j/3].add(num);
                            if (fill(board))
                                return true;
                            else {
                                rows[i].remove(num);
                                columns[j].remove(num);
                                grids[(i/3)*3 + j/3].remove(num);
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
