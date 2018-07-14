package questions.leetcode79;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0)  return false;
        if (word.length() == 0) return true;

        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board[0].length; j++)
                if (board[i][j] == word.charAt(0)){
                    if (search(board, word, 0, i, j))
                        return true;
                }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int curr,int i, int j){
        if (curr==word.length()-1)
            return true;

        char ch = word.charAt(curr);
        char ch_next = word.charAt(curr+1);

        boolean f_up = false;
        boolean f_down = false;
        boolean f_left = false;
        boolean f_right =false;

        board[i][j] = '#';
        if (i>0 && board[i-1][j] == ch_next){
            f_up = search(board, word, curr+1, i-1, j);
            if (f_up)   return true;
        }
        if (i<board.length-1 && board[i+1][j] == ch_next){
            f_down = search(board, word, curr+1, i+1, j);
            if (f_down) return true;
        }
        if (j>0 && board[i][j-1] == ch_next){
            f_left = search(board, word, curr+1, i, j-1);
            if (f_left) return true;
        }
        if (j<board[0].length-1 && board[i][j+1] == ch_next){
            f_right = search(board, word, curr+1, i, j+1);
            if (f_right) return true;
        }
        board[i][j] = ch;
        return false;
    }
}
