package questions.leetcode494;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0 || S > 1000 || S < -1000)   return 0;

        int[] dp = new int[2001];
        dp[1000-nums[0]] = 1;
        dp[1000+nums[0]] += 1;

        for (int i=1; i<nums.length; i++){
            int[] next = new int[2001];
            for (int j=0; j<=2000; j++){
                if (dp[j] > 0){
                    next[j+nums[i]] += dp[j];
                    next[j-nums[i]] += dp[j];
                }
            }
            dp = next;
        }
        return dp[1000+S];
    }
}
