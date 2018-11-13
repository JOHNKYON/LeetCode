package questions.leetcode664;

public class StrangePrinter {
    int[][] memo;
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        memo = new int[n][n];
        return helper(s, 0, n-1);
    }

    private int helper(String s, int i, int j) {
        if (i > j)
            return 0;
        if (memo[i][j] != 0)
            return memo[i][j];

        int res = 1 + helper(s, i+1, j);
        for (int k=i+1; k<=j; k++) {
            if (s.charAt(k) == s.charAt(i)) {
                res = Math.min(res, helper(s, i, k-1) + helper(s, k+1, j));
            }
        }
        memo[i][j] = res;
        return res;
    }
}
