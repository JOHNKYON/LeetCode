package questions.leetcode321;

public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int m = nums2.length;
        int[] res = new int[k];

        for (int i=Math.max(0, k-m); i<=k && i<=n; i++) {
            int[] candidate = merge(maxSingle(nums1, i), maxSingle(nums2, k-i));
            res = greater(res, 0, candidate, 0)? res: candidate;
        }

        return res;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] res = new int[n+m];

        int ptr1 = 0, ptr2 = 0;
        for (int i=0; i< m+n; i++) {
            res[i] = greater(nums1, ptr1, nums2, ptr2)? nums1[ptr1++] : nums2[ptr2++];
        }
        return res;
    }

    private int[] maxSingle(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];

        for (int i=0, j=0; i<n; i++) {
            while (j > 0 && res[j-1] < nums[i] && k-j < n-i)
                j--;
            if (j < k)
                res[j++] = nums[i];
        }

        return res;
    }

    private boolean greater(int[] nums1, int index1, int[] nums2, int index2) {
        while (index1 < nums1.length && index2 < nums2.length && nums1[index1] == nums2[index2]) {
            index1++;
            index2++;
        }
        return index2 == nums2.length || (index1 < nums1.length && nums1[index1] > nums2[index2]);
    }
}
