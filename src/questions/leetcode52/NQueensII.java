package questions.leetcode52;

public class NQueensII {
    boolean[] cols;
    boolean[] diags;
    boolean[] antis;
    int n;
    int ans;
    public int totalNQueens(int n) {
        cols = new boolean[n];
        diags = new boolean[2*n];
        antis = new boolean[2*n];
        this.n = n;

        ans = 0;
        buildSol(0);
        return ans;
    }

    private void buildSol(int row) {
        if (row == n) {
            ans++;
            return;
        }
        for (int i=0; i<n; i++) {
            int diagIdx = i - row + n;
            int antiIdx = i + row;
            if (cols[i] || diags[diagIdx] || antis[antiIdx])
                continue;
            else {
                cols[i] = true; diags[diagIdx] = true; antis[antiIdx] = true;
                buildSol(row + 1);
                cols[i] = false; diags[diagIdx] = false; antis[antiIdx] = false;
            }
        }
    }
}
