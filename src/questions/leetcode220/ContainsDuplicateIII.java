package questions.leetcode220;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        for (int i=0; i<n; i++) {
            long num = nums[i];
            for (int j=1; j<=k && i+j < n; j++) {
                long next = nums[i+j];
                if (Math.abs(num - next) <= t)
                    return true;
            }
        }
        return false;
    }
}
