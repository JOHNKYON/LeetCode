package questions.Leetcode312;

public class BrustBalloons {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        return maxCoins(nums, dp, 0, nums.length-1);
    }

    private int maxCoins(int[]nums, int[][] dp, int start, int end){
        if (start > end)    return 0;

        if (dp[start][end] != 0)    return dp[start][end];


        int val = 0;
        for(int i=start; i<=end; i++){
            int cur = maxCoins(nums, dp, start, i-1) +
                    maxCoins(nums, dp, i+1, end) +
                    get(nums, start-1) * nums[i] * get(nums, end+1);
            val = Math.max(val, cur);
        }
        dp[start][end] = val;
        return val;
    }

    private int get(int[] nums, int i){
        if (i<0 || i >= nums.length)
            return 1;
        return nums[i];
    }
}
