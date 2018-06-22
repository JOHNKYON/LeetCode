import questions.leetcode228.SummaryRanges;


public class Main {
    public static void main(String[] args) {

        SummaryRanges method = new SummaryRanges();
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

        int[] input = new int[]{0,1,2,4,5};
        System.out.print(method.summaryRanges(input));
    }
}
