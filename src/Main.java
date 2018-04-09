import questions.leetcode140.WordBreak2;
import questions.leetcode146.LRUCache;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args){
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.print(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.print(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.print(cache.get(1));       // returns -1 (not found)
        System.out.print(cache.get(3));       // returns 3
        System.out.print(cache.get(4));       // returns 4

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


//        System.out.print(method.wordBreak(s, dic));
    }

}
