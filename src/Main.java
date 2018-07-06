import questions.leetcode32.LongestValidParentheses;
import questions.leetcode46.Permutation;

public class Main {
    public static void main(String[] args) {

        Permutation method = new Permutation();
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
        int[] nums = {1,2};
        System.out.print(method.permute(nums));
    }
}
