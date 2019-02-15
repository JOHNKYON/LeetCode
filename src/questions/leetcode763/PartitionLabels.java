package questions.leetcode763;

import java.util.*;

public class PartitionLabels {
    List<Integer> pivots;
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        pivots = new ArrayList<>();
        int left = 0;
        pivots.add(S.length());

        cut(S, 0);
        Collections.sort(pivots);
        for (int pivot: pivots) {
            ans.add(pivot-left);
            left = pivot;
        }
        return ans;
    }

    private void cut(String s, int last_pivot) {
        if (s.length() == 0)
            return;
        Set<Character> set = new HashSet<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c, i+1) == -1) {
                set.remove(c);
            } else
                set.add(c);

            if (set.isEmpty() && i != s.length()-1) {
                pivots.add(i+last_pivot+1);
                cut(s.substring(0, i+1), i+last_pivot+1);
                cut(s.substring(i+1, s.length()), i+last_pivot+1);
                break;
            }
        }
    }
}
