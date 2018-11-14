package questions.leetcode351;

public class AndroidUnlockPatterns {
    boolean[] board;
    public int numberOfPatterns(int m, int n) {
        board = new boolean[9];
        m = Math.max(1, m);
        n = Math.min(9, n);

        int res = 0;
        for (int i=m; i<=n; i++) {
            res += track(-1, i);
            reset();
        }

        return res;
    }

    private void reset() {
        for (int i=0; i<9; i++)
            board[i] = false;
    }

    private int track(int last, int len) {
        if (len == 0)
            return 1;
        int res = 0;
        for (int i=0; i<9; i++) {
            if (isValid(last, i)) {
                board[i] = true;
                res += track(i, len-1);
                board[i] = false;
            }
        }
        return res;
    }

    private boolean isValid(int last, int next) {
        if (board[next])
            return false;
        // first digit of the pattern
        if (last == -1)
            return true;
        // knight moves or adjacent cells (in a row or in a column)
        if ((next + last) % 2 == 1)
            return true;
        // indexes are at both end of the diagonals for example 0,0, and 8,8
        int mid = (next + last)/2;
        if (mid == 4)
            return board[mid];
        // adjacent cells on diagonal  - for example 0,0 and 1,0 or 2,0 and //1,1
        if ((next%3 != last%3) && (next/3 != last/3)) {
            return true;
        }
        // all other cells which are not adjacent
        return board[mid];
    }
}
