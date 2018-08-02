import questions.leetcode309.BestTimetoBuyandSellStockwithCooldown;

public class Main {
    public static void main(String[] args) {

        BestTimetoBuyandSellStockwithCooldown method = new BestTimetoBuyandSellStockwithCooldown();
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
        int[] nums = {2,1};
//        int[] nums = {10,9,2,5,3,7,101,18};
//        method.deserialize(str);
        System.out.print(method.maxProfit(nums));
    }
}
