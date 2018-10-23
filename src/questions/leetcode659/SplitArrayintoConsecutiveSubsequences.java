package questions.leetcode659;

import java.util.ArrayList;
import java.util.HashMap;
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

    public boolean isPossible2(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;

        Counter count = new Counter();
        Counter tails = new Counter();
        for (int x: nums) count.add(x, 1);

        for (int x: nums) {
            if (count.get(x) == 0) {
                continue;
            } else if (tails.get(x) > 0) {
                tails.add(x, -1);
                tails.add(x+1, 1);
            } else if (count.get(x+1) > 0 && count.get(x+2) > 0) {
                count.add(x+1, -1);
                count.add(x+2, -1);
                tails.add(x+3, 1);
            } else
                return false;
            count.add(x, -1);
        }
        return true;
    }

    private class Counter extends HashMap<Integer, Integer> {
        public int get(int k) {
            return containsKey(k) ? super.get(k): 0;
        }

        public void add(int k, int v) {
            put(k, get(k) + v);
        }
    }
}
