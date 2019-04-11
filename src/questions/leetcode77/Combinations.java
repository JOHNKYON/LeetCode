package questions.leetcode77;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        build(path, 1, n, k);
        return ans;
    }

    private void build(List<Integer> path, int start, int n, int k) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i=start; i<=n; i++) {
            path.add(i);
            build(path, i+1, n, k);
            path.remove(path.size() - 1);
        }
    }
}
