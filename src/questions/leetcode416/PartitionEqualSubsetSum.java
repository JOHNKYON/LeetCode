package questions.leetcode416;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums)
            sum += n;

        if ((sum & 1) == 1)
            return false;

        boolean[][] dp = new boolean[nums.length+1][sum+1];

        for (int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], false);
        }

        dp[0][0] = true;
        for (int i=0; i<nums.length; i++){
            for (int j=0; j<=sum; j++){
                if (dp[i][j]){
                    dp[i+1][j] = true;
                    dp[i+1][j+nums[i]] = true;
                }
            }
        }

        for (int i=0; i<dp.length; i++){
            if (dp[i][sum/2])
                return true;
        }
        return false;
    }
}
