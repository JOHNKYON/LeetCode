import questions.leetcode42.TrappingRainWater;
import questions.leetcode44.WildCardMatching;

public class Main {
    public static void main(String[] args){
        WildCardMatching method = new WildCardMatching();
        String s = "";
        String p = "*";
//        method.trap(nums);
//        for (int i : nums){
//            System.out.print(i);
//        }
        System.out.print(method.isMatch(s, p));
    }

}
