package questions.leetcode152;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums == null)    return 1;

        int max_here = nums[0];
        int min_here = nums[0];
        int max = max_here;

        for (int i = 1; i<nums.length; i++){
            if (nums[i] < 0){
                int temp = max_here;
                max_here = min_here;
                min_here = temp;
            }

            max_here = Math.max(nums[i], max_here*nums[i]);
            min_here = Math.min(nums[i], min_here*nums[i]);

            max = Math.max(max_here, max);
        }

        return max;
    }
}
