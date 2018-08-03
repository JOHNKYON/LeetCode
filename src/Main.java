import questions.leetcode322.CoinChange;

public class Main {
    public static void main(String[] args) {

        CoinChange method = new CoinChange();
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
        int[] nums = {1,2,5};
//        int[] nums = {10,9,2,5,3,7,101,18};
//        method.deserialize(str);
        System.out.print(method.coinCHangeIterative(nums, 11));
    }
}
