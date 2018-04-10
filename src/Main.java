import questions.leetcode155.MinStack;
import questions.leetcode162.FindPeakElement;


public class Main {
    public static void main(String[] args){

        FindPeakElement method = new FindPeakElement();
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


        int[] nums = {1};
        System.out.print(method.findPeakElement(nums));
    }

}
