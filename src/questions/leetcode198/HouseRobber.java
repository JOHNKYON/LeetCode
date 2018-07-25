package questions.leetcode198;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0)   return 0;
        if (nums.length == 1)   return nums[0];

        int length = nums.length;

        nums[1] = (nums[0] > nums[1])? nums[0] : nums[1];

        for (int i = 2; i<length; i++){
            int temp = nums[i-2] + nums[i];
            nums[i] = (temp > nums[i-1])? temp : nums[i-1];
        }

        return nums[length-1];
    }
}
