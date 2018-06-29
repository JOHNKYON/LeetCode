
import questions.leetcode239.SlidingWindowMaximum;


public class Main {
    public static void main(String[] args) {

        SlidingWindowMaximum method = new SlidingWindowMaximum();
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

        int[] input = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.print(method.maxSlidingWindow(input, 3));
    }
}
