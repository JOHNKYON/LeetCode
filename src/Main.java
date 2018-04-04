import questions.leetcode50.PowXN;
import questions.leetcode54.SpiralMatrix;

public class Main {
    public static void main(String[] args){
        SpiralMatrix method = new SpiralMatrix();
        int[][] matrix =    {{1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12},
                            {13,14,15,16}};
//        method.trap(nums);
//        for (int i : nums){
//            System.out.print(i);
//        }
        System.out.print(method.spiralOrder(matrix).toString());
    }

}
