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
}
