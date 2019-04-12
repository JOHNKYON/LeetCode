package questions.leetcode51;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    boolean[] cols;
    boolean[] diags;
    boolean[] antis;
    int n;
    public List<List<String>> solveNQueens(int n) {
        cols = new boolean[n];
        diags = new boolean[2*n];
        antis = new boolean[2*n];
        this.n = n;

        List<List<String>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        buildSol(ans, 0, path);
        return ans;
    }

    private void buildSol(List<List<String>> ans, int row, List<Integer> path) {
        if (row == n) {
            ans.add(toGrid(path));
            return;
        }
        for (int i=0; i<n; i++) {
            int diagIdx = i - row + n;
            int antiIdx = i + row;
            if (cols[i] || diags[diagIdx] || antis[antiIdx])
                continue;
            else {
                cols[i] = true; diags[diagIdx] = true; antis[antiIdx] = true;
                path.add(i);
                buildSol(ans, row + 1, path);
                path.remove(path.size()-1);
                cols[i] = false; diags[diagIdx] = false; antis[antiIdx] = false;
            }
        }
    }

    private List<String> toGrid(List<Integer> path) {
        List<String> res = new ArrayList<>();
        for (int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<n; j++) {
                if (j == path.get(i))
                    sb.append('Q');
                else
                    sb.append('.');
            }
            res.add(sb.toString());
        }
        return res;
    }
}
