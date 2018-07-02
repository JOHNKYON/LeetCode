package questions.leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;

        if (length <= 2) return res;

        Arrays.sort(nums);

        for (int i = 0; i<length-2; i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;

            int sum = 0 - nums[i];
            int m = i+1;
            int n = length-1;

            while (m < n){
                if (nums[m] + nums[n] == sum){
                    res.add(Arrays.asList(nums[i], nums[m], nums[n]));
                    m++;
                    n--;
                    while(m < n && nums[m] == nums[m-1]) m++;
                    while(m < n && nums[n] == nums[n+1]) n--;
                }
                else if(nums[m] + nums[n] > sum) n--;
                else m++;
            }
        }

        return res;
    }
}
