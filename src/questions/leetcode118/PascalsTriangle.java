package questions.leetcode118;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0)
            return ans;
        for (int i=0; i<numRows; i++) {
            List<Integer> level = new ArrayList<>();
            level.add(1);
            for (int j=0; j<i-1; j++) {
                level.add(ans.get(i-1).get(j) + ans.get(i-1).get(j+1));
            }
            if (i != 0)
                level.add(1);
            ans.add(level);
        }
        return ans;
    }
}
