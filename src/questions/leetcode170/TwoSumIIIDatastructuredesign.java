package questions.leetcode170;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSumIIIDatastructuredesign {
    List<Integer> nums;

    /** Initialize your data structure here. */
    public TwoSumIIIDatastructuredesign() {
        nums = new ArrayList<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        int idx = Collections.binarySearch(nums, number);
        if (idx < 0) {
            idx = - (idx + 1);
        }
        nums.add(idx, number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        int left = 0, right = nums.size()-1;
        while (left < right) {
            int a = nums.get(left), b = nums.get(right);
            if (a + b == value)
                return true;
            else if (a + b < value)
                left++;
            else
                right--;
        }
        return false;
    }
}
