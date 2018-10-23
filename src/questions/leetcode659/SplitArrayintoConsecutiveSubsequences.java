package questions.leetcode659;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayintoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;

        List<List<Integer>> buckets= new ArrayList<>();
        List<Integer> kickstart = new ArrayList<>();
        kickstart.add(nums[0]);
        buckets.add(kickstart);

        boolean inserted = false;

        for (int num: nums) {
            inserted = false;
            for (int i=buckets.size()-1; i>=0; i--) {
                List<Integer> bucket = buckets.get(i);
                if (bucket.get(bucket.size()-1) == num-1) {
                    bucket.add(num);
                    inserted = true;
                    break;
                }
            }
            if (!inserted) {
                List<Integer> bucket = new ArrayList<>();
                bucket.add(num);
                buckets.add(bucket);
            }
        }

        for (List<Integer> bucket: buckets) {
            if (bucket.size() < 3)
                return false;
        }

        return true;
    }
}
