import questions.leetcode79.WordSearch;

public class Main {
    public static void main(String[] args) {

        WordSearch method = new WordSearch();
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
        char[][] board = {{'b','b'},{'a','b'},{'b','a'}};
        String word = "a";
        method.exist(board, word);
//        System.out.print(method.rotate(nums););
    }
}
