package questions.leetcode53;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int max_here = nums[0];
        for (int i=1; i<nums.length; i++){
            max_here = (max_here+nums[i] > nums[i])? max_here+nums[i] : nums[i];
            max_so_far = (max_so_far > max_here)? max_so_far : max_here;
        }

        return max_so_far;
    }
}
