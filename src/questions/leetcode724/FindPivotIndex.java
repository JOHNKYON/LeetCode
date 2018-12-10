package questions.leetcode724;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0)
            return -1;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum[i] = sum[i-1] + nums[i];
        for (int i=0; i<nums.length; i++) {
            if (sum[i] - nums[i] == sum[sum.length-1] - sum[i])
                return i;
        }
        return -1;
    }
}
