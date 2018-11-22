package questions.leetcode348;

public class DesignTicTacToe {
    int n;
    boolean game;
    int[][] board;

    /** Initialize your data structure here. */
    public DesignTicTacToe(int len) {
        n = len;
        board = new int[n][n];
        game = true;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (row < 0 || row >= n || col < 0 || col >= n || board[row][col] != 0)
            return -1;
        board[row][col] = player;
        if (checkWinning(row, col, player))
            return player;
        return 0;
    }

    private boolean checkWinning(int row, int col,int p) {
        boolean hor = true, ver = true, dia1 = false, dia2 = false;
        for (int i=0; i<n; i++) {
            if (board[i][col] != p) {
                ver = false;
                break;
            }
        }
        for (int i=0 ;i<n; i++) {
            if (board[row][i] != p) {
                hor = false;
                break;
            }
        }

        // Diagonal
        if (row == col) {
            dia1 = true;
            for (int i=0; i<n; i++) {
                if (board[i][i] != p) {
                    dia1 = false;
                    break;
                }
            }
        }
        if (row + col == n-1){
            dia2 = true;
            for (int i=0; i<n; i++) {
                if (board[i][n-i-1] != p) {
                    dia2 = false;
                    break;
                }
            }
        }
        return hor || ver || dia1 || dia2;
    }
}
