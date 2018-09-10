package questions.leetcode130;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)  return;

        for (int i=0; i<board[0].length; i++) {
            if (board[0][i] == 'O')
                dp(board, 0, i);
            if (board[board.length-1][i] == 'O')
                dp(board, board.length-1, i);
        }

        for (int i=0; i<board.length; i++) {
            if (board[i][0] == 'O')
                dp(board, i, 0);
            if (board[i][board[0].length-1] == 'O')
                dp(board, i, board[0].length-1);
        }

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == '#')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }

    private void dp(char[][] board, int row, int col){
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return;
        if (board[row][col] == 'X' || board[row][col] == '#')
            return;
        if (board[row][col] == 'O'){
            board[row][col] = '#';
            dp(board, row-1, col);
            dp(board, row, col-1);
            dp(board, row, col+1);
            dp(board, row+1, col);
        }
    }
}
