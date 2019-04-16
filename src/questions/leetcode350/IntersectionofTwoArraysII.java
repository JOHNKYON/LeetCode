package questions.leetcode350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int num: nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (int num: nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int key: map1.keySet()) {
            if (map2.containsKey(key)) {
                int count = Math.min(map1.get(key), map2.get(key));
                while (count-- > 0) {
                    list.add(key);
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i=0; i<ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
