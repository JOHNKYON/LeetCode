import questions.leetcode777.SwapAdjacentinLRString;

public class Main {
    public static void main(String[] args) {

        SwapAdjacentinLRString method = new SwapAdjacentinLRString();
        //        List<InsertInterval.Interval> intervals = new ArrayList<InsertInterval.Interval>(){{
////            add(method.createInterval(6,9));
//            add(method.createInterval(1,5));
//        }};

//        InsertInterval.Interval interval = method.createInterval(0, 0);
//        method.trap(nums);
//        for (int i : nums){
//            System.out.print(i);
//        }®
//        for (InsertInterval.Interval i : method.insert(intervals, interval)){
//            i.print();
//        }
        int[] nums = {1,1,1};
//        int[][] queue = {{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0}};
//        int[][] queue = {{2,4},{3,4},{9,0},{0,6},{7,1},{6,0},{7,3},{2,5},{1,1},{8,0}};

//        method.deserialize(str);
        System.out.print(method.canTransform("XRXXXLXXXR",
                "XXRLXXXRXX"));
    }
}
