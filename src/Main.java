import questions.leetcode85.MaximalRectangle;

public class Main {
    public static void main(String[] args) {

        MaximalRectangle method = new MaximalRectangle();
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
        int[][] bars = {{1,0,1,0,0}};
        method.maximalRectangle(bars);
//        System.out.print(method.rotate(nums););
    }
}
