import questions.leetcode79.WordSearch;
import questions.leetcode84.LargestRectangleInHistogram;

public class Main {
    public static void main(String[] args) {

        LargestRectangleInHistogram method = new LargestRectangleInHistogram();
        //        List<InsertInterval.Interval> intervals = new ArrayList<InsertInterval.Interval>(){{
////            add(method.createInterval(6,9));
//            add(method.createInterval(1,5));
//        }};

//        InsertInterval.Interval interval = method.createInterval(0, 0);
//        method.trap(nums);
//        for (int i : nums){
//            System.out.print(i);
//        }
//        for (InsertInterval.Interval i : method.insert(intervals, interval)){
//            i.print();
//        }
        int[] bars = {2,1,5,6,2,3};
        method.largestRectangleArea(bars);
//        System.out.print(method.rotate(nums););
    }
}
