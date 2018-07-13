package questions.leetcode70;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int a = 0;
        int b = 1;
        int temp;
        if (n == 0) return 0;

        while(0 < n--){
            temp = b;
            b = a+b;
            a = temp;
        }
        return b;
    }
}
