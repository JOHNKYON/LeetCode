import questions.leetcode140.WordBreak2;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args){
        WordBreak2 method = new WordBreak2();

        String s ="catsanddogs";
        List<String> dic = new ArrayList<String>(){{
            add("cats");
            add("and");
            add("dog");
            add("cat");
            add("sand");
        }};
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
        System.out.print(method.wordBreak(s, dic));
    }

}
