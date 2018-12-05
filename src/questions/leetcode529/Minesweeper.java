package questions.leetcode529;

public class Minesweeper {
    static int[][] moves = {{-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (x < 0 || x >= board.length ||
                y < 0 || y >= board[0].length)
            return board;

        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        // int[][] moves = {{-1, -1}, {-1, 0}, {-1, 1},
        //                  {0, -1},           {0, 1},
        //                  {1, -1},  {1, 0},  {1, 1}};

        int adjacent_count = adjacentMines(board, x, y);
        if (adjacent_count != 0) {
            board[x][y]= (char)('0' + adjacent_count);
        } else if (board[x][y] == 'E') {
            board[x][y] = 'B';
            for (int[] move: moves) {
                int[] next_click = new int[2];
                for (int i=0; i<2; i++) next_click[i] = click[i] + move[i];
                updateBoard(board, next_click);
            }
        }

        return board;
    }

    private int adjacentMines(char[][] board, int x, int y) {
        int count = 0;
        for (int[] move: moves) {
            int nx = x + move[0], ny = y + move[1];
            if (nx < 0 || nx >= board.length ||
                    ny < 0 || ny >= board[0].length)
                continue;
            if (board[nx][ny] == 'M')
                count++;
        }
        return count;
    }
}
