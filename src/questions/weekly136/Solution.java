package questions.weekly136;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    HashMap<Integer, List<Integer>> map;
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] ans = new int[n];
        map = new HashMap<>();
        for (int[] path: paths) {
            if (!map.containsKey(path[0]-1))
                map.put(path[0]-1, new ArrayList<>());
            if (!map.containsKey(path[1]-1))
                map.put(path[1]-1, new ArrayList<>());
            map.get(path[0]-1).add(path[1]-1);
            map.get(path[1]-1).add(path[0]-1);
        }
        dfs(ans, 0);
        return ans;
    }

    private boolean dfs(int[] ans, int curr) {
        if (curr >= ans.length)
            return true;
        if (curr == 0) {
            for (int i=1; i<=4; i++) {
                ans[curr] = i;
                boolean valid = dfs(ans, curr + 1);
                if (valid)
                    return true;
            }
        } else {
            for (int i=1; i<=4; i++) {
                List<Integer> neighs = map.get(curr);
                boolean seen = false;
                if (neighs != null) {
                    for (int nei : neighs) {
                        if (ans[nei] == i) {
                            seen = true;
                            break;
                        }
                    }
                }
                if (!seen) {
                    ans[curr] = i;
                    boolean valid = dfs(ans, curr+1);
                    if (valid)
                        return true;
                }
            }
        }
        return false;
    }
}
