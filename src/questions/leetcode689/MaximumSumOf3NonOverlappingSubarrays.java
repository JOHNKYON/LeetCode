package questions.leetcode689;

public class MaximumSumOf3NonOverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return null;

        int n = nums.length;
        int[] memo = new int[n-k+1];
        int sum = 0;
        for (int i=0; i<k; i++) {
            sum += nums[i];
        }
        memo[0] = sum;
        for (int i=1; i<=n-k; i++) {
            memo[i] = memo[i-1] - nums[i-1] + nums[i+k-1];
        }
        int temp = 0;
        int res0=-1, res1=-1, res2 = -1;
        int[] left = new int[memo.length];
        int[] right = new int[memo.length];

        int best = 0;
        for (int i=0; i<memo.length; i++) {
            if (memo[i] > memo[best])
                best = i;
            left[i] = best;
        }
        best = memo.length-1;
        for (int i=memo.length-1; i>=0; i--) {
            if (memo[i] > memo[best])
                best = i;
            right[i] = best;
        }
        for (int j=k; j<memo.length-k; j++) {
            int i = left[j-k];
            int m = right[j+k];
            if (res0 == -1 || memo[i] + memo[j] + memo[m] > memo[res0] + memo[res1] + memo[res2]){
                res0 = i;
                res1 = j;
                res2 = m;
            }
        }

        return new int[]{res0, res1, res2};
    }
}
