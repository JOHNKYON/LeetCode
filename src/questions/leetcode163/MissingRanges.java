package questions.leetcode163;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();

        if(nums.length == 0) {
            res.add(form(lower, upper));
            return res;
        }

        if(lower == Integer.MAX_VALUE) {
            return res;
        }

        int next = lower;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < next)
                continue;

            if(nums[i] == next) {
                next = next+1;
                continue;
            }
            res.add(form(next, nums[i]-1));

            //Overflow : no need to update and check, just return
            if(nums[i] == upper) {
                return res;
            }
            next = nums[i]+1;
        }

        //check if upper didn't overlap in the nums array
        if(next <= upper)
            res.add(form(next, upper));

        return res;
    }

    private String form(int lower, int upper) {
        // Create an output string.
        StringBuilder sb = new StringBuilder();
        if (lower == upper)
            sb.append(lower);
        else {
            sb.append(lower);
            sb.append("->");
            sb.append(upper);
        }
        return sb.toString();
    }
}
