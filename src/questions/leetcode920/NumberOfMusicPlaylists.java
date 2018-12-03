package questions.leetcode920;

public class NumberOfMusicPlaylists {
    public int numMusicPlaylists(int N, int L, int K) {
        int mod = 1_000_000_007;

        long[][] dp = new long[L+1][N+1];
        dp[0][0] = 1;
        for (int i=1; i<=L; i++) {
            for (int j=1; j<=N; j++) {
                dp[i][j] = ((N-j+1) * dp[i-1][j-1]) % mod;
                dp[i][j] += dp[i-1][j] * Math.max(j-K, 0) % mod;
                dp[i][j] %= mod;
            }
        }

        return (int)dp[L][N];
    }
}
