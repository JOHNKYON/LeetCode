import questions.leetcode146.LRUCache;
import questions.leetcode155.MinStack;


public class Main {
    public static void main(String[] args){

        MinStack minStack = new MinStack();
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


        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.print(minStack.getMin());   //--> Returns -3.
        minStack.pop();
        System.out.print(minStack.top());      //--> Returns 0.
        System.out.print(minStack.getMin());   //--> Returns -2.
    }

}
