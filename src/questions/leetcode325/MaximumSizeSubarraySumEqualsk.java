package questions.leetcode325;

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
}
