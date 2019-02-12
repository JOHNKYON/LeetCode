package questions.leetcode45;

public class JumpGameII {
    int[] memo;
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;

        memo = new int[nums.length];
        for (int i=nums.length-2; i>=0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j=Math.min(nums.length-1, i+nums[i]); j > i; j--) {
                if (memo[j] != Integer.MAX_VALUE)
                    min = Math.min(memo[j] + 1, min);
            }
            memo[i] = min;
        }
        return memo[0] == Integer.MAX_VALUE? -1: memo[0];
    }

    public int jump2(int[] nums) {
        int end = 0, furthest = 0;
        int ans = 0;
        for (int i = 0; i<nums.length-1; i++) {
            furthest = Math.max(furthest, nums[i] + i);
            if (i == end) {
                ans++;
                end = furthest;
            }
        }

        return ans;
    }
}
