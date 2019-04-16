package questions.leetcode244;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistanceII {
    HashMap<String, List<Integer>> map;

    public ShortestWordDistanceII(String[] words) {
        map = new HashMap<>();
        for (int i=0; i<words.length; i++) {
            String word = words[i];
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int ans = Integer.MAX_VALUE;
        for (int i: list1) {
            for (int j: list2) {
                ans = Math.min(ans, Math.abs(i-j));
            }
        }
        return ans;
    }
}
