import questions.leetcode686.RepeatedStringMatch;

public class Main {
    public static void main(String[] args) {

        RepeatedStringMatch method = new RepeatedStringMatch();
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
        String[][] eq = {{"a", "b"}, {"b", "c"}};
        String[][] ques = {{"a", "c"}};
        double[] nums = {2, 3};
//        int[][] queue = {{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0}};
//        int[][] queue = {{2,4},{3,4},{9,0},{0,6},{7,1},{6,0},{7,3},{2,5},{1,1},{8,0}};

//        method.deserialize(str);
//        String[] words1 = {"a","very","delicious","meal"};
//        String[] words2 = {"one","really","delicious","dinner"};
//        String[][] pairs = {{"a","one"},{"dinner","meal"},{"super","meal"},{"really","very"},{"super","very"}};
//        System.out.print(method.areSentencesSimilarTwo(words1, words2, pairs));
        System.out.print(method.repeatedStringMatch("a", "a"));
    }
}
