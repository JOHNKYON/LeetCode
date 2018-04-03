import questions.leetcode31.NextPremutation;

public class Main {
    public static void main(String[] args){
        NextPremutation method = new NextPremutation();
        int[] nums = {1,3,2};
        method.nexPermutation(nums);
        for (int i : nums){
            System.out.print(i);
        }
//        System.out.print(method.nexPermutation(nums));
    }

}
