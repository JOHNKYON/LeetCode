package questions.leetcode115;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int len = t.length();

        HashMap<Character, List<Integer>> map = new HashMap<>();

        for (int i=0; i<len; i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c))
                map.put(c, new ArrayList<Integer>());
            map.get(c).add(i);
        }
        int[] index_count = new int[len];

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                List<Integer> indexes = map.get(c);
                if (indexes.get(0) == 0 && index_count[0] == 0) {
                    index_count[0]++;
                    continue;
                }
                for (int j=indexes.size()-1; j>=0; j--) {
                    int index = indexes.get(j);
                    if (index == 0)
                        index_count[0]++;
                    else if (index_count[index-1] != 0)
                        index_count[index] = index_count[index] + index_count[index-1];
                }
            }
        }

        return index_count[len-1];
    }
}
