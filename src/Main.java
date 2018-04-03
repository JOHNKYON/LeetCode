import questions.leetcode31.NextPremutation;
import questions.leetcode42.TrappingRainWater;

public class Main {
    public static void main(String[] args){
        TrappingRainWater method = new TrappingRainWater();
        int[] nums = {5,5,1,7,1,1,5,2,7,6};
//        method.trap(nums);
//        for (int i : nums){
//            System.out.print(i);
//        }
        System.out.print(method.trap(nums));
    }

}
