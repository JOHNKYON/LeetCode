import questions.leetcode128.LongestConsecutiveSequence;


public class Main {
    public static void main(String[] args){
        LongestConsecutiveSequence method = new LongestConsecutiveSequence();
        int[] nums = {100,4,200,1,3,2};
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
        System.out.print(method.longestConsecutive(nums));
    }

}
