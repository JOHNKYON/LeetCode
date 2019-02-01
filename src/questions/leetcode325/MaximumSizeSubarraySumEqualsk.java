package questions.leetcode325;

import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        int[] sums = new int[n+1];
        for (int i=1; i<=n; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }

        for (int i=0; i<=n; i++) {
            for (int j=0; j<=i; j++) {
                if (sums[i] - sums[j] == k)
                    ans = Math.max(ans, i-j);
            }
        }
        return ans;
    }

    public int maxSubArrayLen2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k)
                ans = i+1;
            else if (map.containsKey(sum-k))
                ans = Math.max(ans, i - map.get(sum-k));

            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        return ans;
    }
}
