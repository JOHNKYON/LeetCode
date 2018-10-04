import questions.leetcode346.MovingAverage;
import questions.leetcode855.ExamRoom;

public class Main {
    public static void main(String[] args) {

        MovingAverage method= new MovingAverage(3);

        int[] input = {-2, 1, -1, -2, -2};
        int[][] hits = {{1,1,1}, {7,7,7}, {7,7,7}};

//        System.out.print(method.circularArrayLoop(input));
        method.next(1);
        method.next(10);
        method.next(3);
        method.next(5);
    }
}
