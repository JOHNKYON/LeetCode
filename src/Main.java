import questions.leetcode297.SerializeandDeserializeBinaryTree;

public class Main {
    public static void main(String[] args) {

        SerializeandDeserializeBinaryTree method = new SerializeandDeserializeBinaryTree();
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
        String str = "1,2,3,null,null,4,5";
//        method.deserialize(str);
        System.out.print(method.deserialize(str));
    }
}
