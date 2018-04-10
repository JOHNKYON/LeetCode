package questions.leetcode162;

/**
 * Created by JOHNKYON on 2018/4/10.
 * This is a solution to LeetCode Questions.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums){
        int left = 0, right = nums.length-1;
        if (right == 0){
            return 0;
        }

        while (left <= right){
            int mid = left + (right - left)/2;
            if (mid == 0){
                if (nums[1] < nums[0]){
                    return 0;
                }else {left = mid+1;continue;}
            } if (mid == nums.length-1){
                if (nums[mid-1] < nums[mid]){
                    return mid;
                }else {right = mid-1;continue;}
            }
            if ( nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid]){
                return mid;
            } else {
                if (nums[mid-1] > nums[mid]){
                    right = mid-1;
                }else {left = mid+1;}
            }
        }
        return left;
    }
}
