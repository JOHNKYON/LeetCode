package questions.leetcode88;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int curr = m+n;
        int ptr1 = m-1;
        int ptr2 = n-1;
        while (curr-- > 0) {
            if (ptr1 < 0)
                nums1[curr] = nums2[ptr2--];
            else if (ptr2 < 0)
                nums1[curr] = nums1[ptr1--];
            else {
                if (nums1[ptr1] > nums2[ptr2])
                    nums1[curr] = nums1[ptr1--];
                else
                    nums1[curr] = nums2[ptr2--];
            }
        }
    }
}
