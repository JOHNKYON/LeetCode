package questions.leetcode523;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1)
            return false;

        if (k == 0) {
            for (int i=0; i<n; i++) {
                if (nums[i] == 0 && i < n-1 && nums[i+1] == 0)
                    return true;
            }
            return false;
        }

        int[] dp = new int[n+1];
        for (int i=1; i<=n; i++) {
            dp[i] = dp[i-1] + nums[i-1];
        }

        for (int i=1; i<=n; i++) {
            for (int j=0; j<i-1; j++) {
                if ((dp[i] - dp[j]) % k == 0)
                    return true;
            }
        }
        return false;
    }
}
