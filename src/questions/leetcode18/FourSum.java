package questions.leetcode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length <= 3)
            return ans;
        if (4 * nums[0] > target)
            return ans;
        if (4 * nums[nums.length-1] < target)
            return ans;
        int max = nums[nums.length-1];
        for (int i=0; i<nums.length-3; i++) {
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            if (nums[i] + max * 3 < target)
                continue;
            if (nums[i] * 4 > target) {
                break;
            }
            if (nums[i] * 4 == target) {
                if (i < nums.length-3 && nums[i+3] == nums[i]) {
                    ans.add(Arrays.asList(nums[i], nums[i],nums[i],nums[i]));
                }
                break;
            }

            threeSum(nums, target-nums[i], i, nums[i], ans);
        }

        return ans;
    }

    private void threeSum(int[] nums, int target, int last, int num1, List<List<Integer>> ans) {
        int n = nums.length;
        int max = nums[n-1];
        for (int i=last+1; i<n-2; i++) {
            if (i > last+1 && nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i] + 2 * max < target)
                continue;
            if (nums[i] * 3 > target)
                break;
            if (nums[i] * 3 == target) {
                if (i < n-2 && nums[i+2] == nums[i]) {
                    ans.add(Arrays.asList(num1, nums[i], nums[i], nums[i]));
                    break;
                }
            }

            twoSum(nums, target - nums[i], i, num1, nums[i], ans);
        }
    }

    private void twoSum(int[] nums, int target, int last, int num1, int num2, List<List<Integer>> ans) {
        int n = nums.length;
        int left = last+1, right = n-1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                ans.add(Arrays.asList(num1, num2, nums[left], nums[right]));
                left++;
                right--;
                while (left < right && nums[left] == nums[left-1])
                    left++;
                while (left < right && nums[right] == nums[right+1])
                    right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
