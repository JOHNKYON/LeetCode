package questions.leetcode724;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0)
            return -1;
        int sum = 0;
        for (int n:nums)
            sum += n;
        int curr = 0;
        for (int i=0; i<nums.length; i++) {
            if (sum - nums[i] - curr == curr)
                return i;
            curr += nums[i];
        }
        return -1;
    }
}
