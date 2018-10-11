package questions.leetcode303;

public class RangeSumQueryImmutable {
    int[] sum;

    public RangeSumQueryImmutable(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int n = nums.length;
        sum = new int[n];
        sum[0] = nums[0];
        for (int i=1; i<n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
    }
}
