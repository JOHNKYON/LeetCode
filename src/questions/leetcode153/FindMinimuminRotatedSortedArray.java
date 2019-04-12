package questions.leetcode153;

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        if (nums[left] < nums[right])
            return nums[left];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right])
                right = mid;
            else
                left = mid + 1;
        }
        return nums[left];
    }
}
