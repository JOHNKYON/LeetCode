package questions.leetcode35;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        int res = 0;
        while (left <= right){
            int mid = (left+right)/2;
            if (nums[mid] == target)   return mid;
            if (nums[mid] < target)     left = mid+1;
            else    right = mid - 1;
        }
        return left;
    }
}
