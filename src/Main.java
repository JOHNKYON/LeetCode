import questions.leetcode224.BasicCalculator;


public class Main {
    public static void main(String[] args) {

        BasicCalculator method = new BasicCalculator();
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

        int[][] input = new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        System.out.print(method.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
