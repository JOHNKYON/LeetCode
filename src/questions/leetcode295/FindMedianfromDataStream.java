package questions.leetcode295;

import java.util.ArrayList;
import java.util.List;

public class FindMedianfromDataStream {
    List<Integer> nums;

    /** initialize your data structure here. */
    public FindMedianfromDataStream() {
        nums = new ArrayList<>();
    }

    public void addNum(int num) {
        if (nums.size() == 0)
            nums.add(num);
        else {
            int lo = 0, hi = nums.size()-1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2 ;
                if (nums.get(mid) == num) {
                    nums.add(mid, num);
                    return;
                } else if (nums.get(mid) < num) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            nums.add(lo, num);
        }
    }

    public double findMedian() {
        if ((nums.size() & 1) == 1) {
            double med = (double)nums.get(nums.size()/2);
            return med;
        } else {
            double med1 = (double)nums.get(nums.size()/2);
            double med2 = (double)nums.get(nums.size()/2 - 1);
            return (med1 + med2) / 2;
        }
    }
}
