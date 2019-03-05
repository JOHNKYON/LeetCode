package questions.leetcode259;

import java.util.Arrays;

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            ans += twoSumSmaller(nums, i+1, target - nums[i]);
        }
        return ans;
    }

    private int twoSumSmaller(int[] nums, int left, int target) {
        int right = nums.length - 1;
        int ans = 0;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                ans += right - left;
                left++;
            } else
                right--;
        }
        return ans;
    }
}
