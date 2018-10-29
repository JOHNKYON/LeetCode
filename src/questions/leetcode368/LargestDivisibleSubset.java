package questions.leetcode368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;

        int n = nums.length;
        int[][] dp = new int[n][2];
        Arrays.sort(nums);

        int max_ptr = 0;
        int max_len = 0;

        for (int i=0; i<n; i++) {
            dp[i][0] = 1;
            dp[i][1] = -1;
            int temp = -1;
            for (int j=0; j<i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j][0] > temp) {
                    temp = dp[j][0];
                    dp[i][0] = temp+1;
                    dp[i][1] = j;
                }
            }
            if (max_len < dp[i][0]) {
                max_len = dp[i][0];
                max_ptr = i;
            }
        }

        while (max_ptr >= 0) {
            res.add(nums[max_ptr]);
            max_ptr = dp[max_ptr][1];
        }

        return res;
    }
}
