package questions.leetcode349;

import java.util.HashSet;

public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res_list = new HashSet<>();

        for (int i: nums1){
            if (!set.contains(i))
                set.add(i);
        }

        for (int i: nums2){
            if (set.contains(i) && !res_list.contains(i))
                res_list.add(i);
        }

        int[] res = new int[res_list.size()];

        int i = 0;
        for (Integer n : res_list){
            res[i] = n;
            i++;
        }

        return res;
    }
}
