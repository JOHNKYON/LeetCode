
import questions.leetcode48.RotateImage;

public class Main {
    public static void main(String[] args) {

        RotateImage method = new RotateImage();
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
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        method.rotate(nums);
//        System.out.print(method.rotate(nums););
    }
}
