package questions.leetcode229;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums.length == 0)
            return ans;
        if (nums.length == 1){
            ans.add(nums[0]);
            return ans;
        }
        int maj0 = nums[0];
        int maj1 = nums[1];
        double count0 = 1;
        double count1 = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == maj0)
                count0++;
            else if (nums[i] == maj1)
                count1++;
            else if (count0 == 0) {
                maj0 = nums[i];
                count0 = 1;
            } else if (count1 == 0) {
                maj1 = nums[i];
                count1 = 1;
            } else {
                count0--;
                count1--;
            }
        }

        count0 = 0;
        count1 = 0;
        for (int i: nums){
            if (i == maj0)
                count0++;
            if (i == maj1)
                count1++;
        }
        if (count0 > nums.length/3)
            ans.add(maj0);
        if (count1 > nums.length/3 && maj0 != maj1)
            ans.add(maj1);
        return ans;
    }
}
