package questions.leetcode62;

public class UniquePath {
    public int uniquePaths(int m, int n) {
        /* There're in total m+n-2 steps to take.
         *  In them there're in total n-1 steps down.
         *  The problem is a cominatoric problem.
         */

        double total_step = m + n - 2;
        double down_step = (m>n)? n-1 : m-1;

        double res = 1;

        for (int i=1; i<=down_step; i++){
            res = res*(total_step-down_step+i)/i;
        }

        return (int)res;

    }
}
