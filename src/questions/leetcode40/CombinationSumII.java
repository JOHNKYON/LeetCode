package questions.leetcode40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(candidates, 0, target, path);
        return ans;
    }

    private void helper(int[] candidates, int start, int target, List<Integer> path) {
        if (target < 0)
            return;
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i=start; i<candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1])
                continue;
            path.add(candidates[i]);
            helper(candidates, i + 1, target - candidates[i], path);
            path.remove(path.size() - 1);
        }
    }
}
