package questions.leetcode419;

public class BattleshipsInBoard {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return 0;
        int n = board.length, m = board[0].length;
        int res = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == 'X') {
                    modify(i, j, board);
                    res++;
                }
            }
        }
        return res;
    }

    private void modify(int i, int j, char[][] board) {
        if (i < 0 || i>=board.length || j < 0 || j >= board[0].length)
            return;
        int[][] moves = {{0,1}, {0,-1},{1,0},{-1,0}};
        if (board[i][j] == 'X') {
            board[i][j] = '.';
            for (int[] move: moves) {
                modify(i+move[0], j+move[1], board);
            }
        }
    }

    public int countBattleships2(char[][] board) {
        int m = board.length;
        if (m==0) return 0;
        int n = board[0].length;

        int count=0;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i-1][j] == 'X') continue;
                if (j > 0 && board[i][j-1] == 'X') continue;
                count++;
            }
        }

        return count;
    }
}
