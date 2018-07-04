package questions.leetcode34;

public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int res0 = 0, res1 = 0;

        int left = 0, right = nums.length-1;

        int pivot = -1;
        while (left <= right){
            int mid = (left+right)/2;
            if (nums[mid] == target) {
                pivot = mid;
                break;
            }
            else if (nums[mid] < target)  left = mid + 1;
            else    right = mid - 1;
        }

        if (pivot == -1) return new int[]{-1, -1};

            // return new int[]{pivot};

        else {
            left = 0;
            right = pivot;
            int mid_index = (left + right)/2;

            while(nums[mid_index] != target || !(mid_index == 0 || nums[mid_index-1] < target)) {
                if (nums[mid_index] < target)   left = mid_index+1;
                else    right = mid_index-1;
                mid_index = (left+right)/2;
            }
            res0 = mid_index;

            left = pivot;
            right = nums.length-1;
            mid_index = (left + right)/2;
            while(nums[mid_index] != target || !(mid_index == nums.length-1 || nums[mid_index+1] > target)) {
                if (nums[mid_index] > target)   right = mid_index-1;
                else    left = mid_index+1;
                mid_index = (left+right)/2;
            }
            res1 = mid_index;
        }
        return new int[]{res0, res1};
    }
}
