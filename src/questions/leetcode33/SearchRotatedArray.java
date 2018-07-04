package questions.leetcode33;

public class SearchRotatedArray {
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length-1;

        if (right == -1)    return -1;

        int pivot = searchPivot(nums, left, right);

        if (pivot == right)
            return division2(nums, target, left, right);

        if (target  >= nums[left]) return division2(nums, target, left, pivot);
        else return division2(nums, target, pivot+1, right);
    }

    private int searchPivot(int[] nums, int left, int right){
        if (nums[right] >= nums[left])   return right;

        int mid_index = (left+right)/2;
        if (nums[mid_index] > nums[mid_index+1])    return mid_index;
        else {
            if (nums[mid_index] < nums[left])   return searchPivot(nums, left, mid_index);
            else return searchPivot(nums, mid_index, right);
        }
    }

    private int division2(int[] nums, int target, int left, int right){
        while(left <= right){
            int mid_index = (left+right)/2;
            int mid = nums[mid_index];
            if (mid == target)  return mid_index;
            else if (mid < target)  return division2(nums, target, mid_index+1, right);
            else return division2(nums, target, left, mid_index-1);
        }
        return -1;
    }
}
