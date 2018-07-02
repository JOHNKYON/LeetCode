package questions.leetcode228;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums){
        List<String> res = new ArrayList<>();

        if (nums == null || nums.length == 0) return res;

        int left = nums[0];
        int right = nums[0];

        for (int i = 1; i<nums.length; i++){
            if (nums[i] == right+1) right+=1;
            else {
                if (left == right) res.add(String.valueOf(left));
                else {
                    res.add(String.valueOf(left)+"->"+String.valueOf(right));
                }

                left = right = nums[i];
            }
        }
        if (left == right) res.add(String.valueOf(left));
        else {
            res.add(String.valueOf(left)+"->"+String.valueOf(right));
        }

        return res;
    }
}
