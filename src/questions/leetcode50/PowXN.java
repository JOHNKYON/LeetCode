package questions.leetcode50;

/**
 * Created by JOHNKYON on 2018/4/4.
 * This is a solution to LeetCode Questions.
 */
public class PowXN {
    public double myPow(double x, int n){
        double ans = 1;
        long absN = Math.abs((long)n);
        while (absN > 0){
            if ((absN&1) == 1) {ans *= x;}
            absN >>= 1;
            x *= x;
        }
        return n < 0 ? 1/ans : ans;
    }
}
