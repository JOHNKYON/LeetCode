package questions.leetcode546;

public class RemoveBoxes {
    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0)
            return 0;

        int n = boxes.length;
        int[][][] dp = new int[n][n][n];

        return calculatePoints(boxes, dp, 0, n-1, 0);
    }

    private int calculatePoints(int[] boxes, int[][][] dp, int l, int r, int k) {
        if (l > r)
            return 0;
        if (dp[l][r][k] != 0)
            return dp[l][r][k];
        while (r > 1 && boxes[r] == boxes[r-1]) {
            r--;
            k++;
        }
        dp[l][r][k] = calculatePoints(boxes, dp, l, r-1, 0) + (k+1) * (k+1);
        for (int i=l; i<r; i++) {
            if (boxes[i] == boxes[r]) {
                dp[l][r][k] = Math.max(dp[l][r][k], calculatePoints(boxes, dp, l, i, k+1) + calculatePoints(boxes, dp, i+1, r-1, 0));
            }
        }
        return dp[l][r][k];
    }
}
