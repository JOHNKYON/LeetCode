package questions.leetcode5037;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ParallelCourses {
    public int minimumSemesters(int n, int[][] relations) {
        int ans = 0;
        int[] ranks = new int[n+1];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] relation: relations) {
            int a = relation[0], b = relation[1];
            ranks[b]++;
            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            map.get(a).add(b);
        }
        HashSet<Integer> taken = new HashSet<>();
        int last = -1;
        int curr = 0;
        while (last != curr) {
            last = curr;
            curr = 0;
            List<Integer> round = new ArrayList<>();
            for (int i=1; i<=n; i++) {
                if (ranks[i] == 0) {
                    curr++;
                    if (!taken.contains(i)) {
                        round.add(i);
                    }
                }
            }
            if (last == curr) {
                break;
            }
            for (int i: round) {
                List<Integer> nexts = map.get(i);
                if (nexts == null) {
                    continue;
                }
                for (int j: nexts) {
                    if (ranks[j] > 0) {
                        ranks[j]--;
                    }
                }
                taken.add(i);
            }

            ans++;
        }
        return (curr == n)?ans: -1;
    }
}
