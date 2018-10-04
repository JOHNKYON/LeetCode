import questions.leetcode855.ExamRoom;

public class Main {
    public static void main(String[] args) {

        ExamRoom method= new ExamRoom(4);

        int[] input = {-2, 1, -1, -2, -2};
        int[][] hits = {{1,1,1}, {7,7,7}, {7,7,7}};

//        System.out.print(method.circularArrayLoop(input));
        method.seat();
        method.seat();
        method.seat();
        method.seat();
        method.leave(1);
        method.leave(3);
        method.seat();
    }
}
