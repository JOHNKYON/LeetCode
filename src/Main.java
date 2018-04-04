import questions.leetcode50.PowXN;
import questions.leetcode54.SpiralMatrix;
import questions.leetcode56.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        MergeIntervals method = new MergeIntervals();
        List<MergeIntervals.Interval> intervals = new ArrayList<MergeIntervals.Interval>(){{
            add(method.createInterval(1,3));
            add(method.createInterval(2,6));
            add(method.createInterval(8,10));
            add(method.createInterval(15,18));
        }};
//        method.trap(nums);
//        for (int i : nums){
//            System.out.print(i);
//        }
        System.out.print(method.merge(intervals).toString());
    }

}
