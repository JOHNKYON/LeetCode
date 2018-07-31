package questions.leetcode279;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] count = new int[n+1];
        count[0] = 0;
        for (int i = 1; i<=n; i++){
            count[i] = Integer.MAX_VALUE;
            for(int j = 1; j*j<=i; j++){
                count[i] = (count[i-j*j]+1 < count[i])? count[i-j*j]+1 : count[i];
            }
        }

        return count[n];
    }

    public int fastNumSquares(int n) {
        /*
        * Referring to Lagrange's Four Square Theorem.
        * */
        int sqr = (int)Math.sqrt(n);
        if (isSquare(n))   return 1;

        int temp = n;
        while (temp%4 == 0){
            temp /= 4;
        }
        if (temp%8 == 7)
            return 4;

        for(int i = 1; i<= sqr; i++){
            temp = n;
            temp -= i*i;
            if (isSquare(temp)) return 2;
        }

        return 3;
    }

    private boolean isSquare(int n){
        int sqr = (int)Math.sqrt(n);
        if (sqr*sqr == n)   return true;
        else    return false;
    }
}
