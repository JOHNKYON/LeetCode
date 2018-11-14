package questions.leetcode688;

public class KnightProbabilityInCheeseboard {
    double[][][] memo;
    public double knightProbability(int N, int K, int r, int c) {
        memo = new double[N][N][K+1];
        jump(N, K, r, c);
        return memo[r][c][K];
    }

    private double jump(int n, int k, int r, int c) {
        if (r < 0 || r >= n || c < 0 || c >= n)
            return 0;
        if (memo[r][c][k] != 0)
            return memo[r][c][k];
        if (k == 0) {
            memo[r][c][k] = 1;
            return 1;
        }
        double count = 0;
        int[][] moves = {{1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}, {-2,-1}, {-2,1}, {-1,2}};
        for (int[] move:moves) {
            count += jump(n, k-1, r+move[0], c+move[1]);
        }
        count /= 8;
        memo[r][c][k] = count;
        return count;
    }
}
