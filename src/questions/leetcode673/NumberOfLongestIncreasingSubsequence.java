package questions.leetcode673;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int[] lens = new int[n];
        int[] counts = new int[n];
        Arrays.fill(counts, 1);

        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    if (lens[j] >= lens[i]){
                        lens[i] = lens[j] + 1;
                        counts[i] = counts[j];
                    }
                    else if (lens[j] + 1 == lens[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
        }

        int longest = 0, ans = 0;
        for (int len:lens)
            longest = Math.max(longest, len);
        for (int i=0; i<n; i++) {
            if (lens[i] == longest)
                ans += counts[i];
        }

        return ans;
    }
}
