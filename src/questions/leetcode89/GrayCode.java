package questions.leetcode89;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();
        int curr = 0;
        ans.add(curr);
        seen.add(curr);
        int goal = 1;
        for (int i=0; i<n; i++) {
            goal *= 2;
        }
        while (ans.size() < goal) {
            curr = next(curr, n, seen);
            seen.add(curr);
            ans.add(curr);
        }
        return ans;
    }

    private int next(int curr, int n, HashSet<Integer> seen) {
        int mask = 1;
        for (int i=0; i<n; i++) {
            int next = curr ^ (mask << i);
            if (!seen.contains(next))
                return next;
        }
        return curr;
    }
}
