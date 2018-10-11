package questions.leetcode123;

public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;

        int[][] dp = new int[n][n];

        for (int len = 1; len<=n; len++) {
            for (int i=0; i + len -1 <n; i++) {
                // i as starting point
                int temp = Math.max(0, prices[i+len-1] - prices[i]);
                for (int sub=1; sub<len; sub++) {

                    if (len == n) {
                        res = Math.max(res, temp);
                        res = Math.max(res, dp[i][i+sub-1] + dp[i+sub][i+len-1]);
                    }
                    else {
                        temp = Math.max(temp, dp[i][i + sub - 1]);
                        temp = Math.max(temp, dp[i + sub][i + len - 1]);
                    }


                }
                dp[i][i+len-1] = temp;
            }
        }
        return res;
    }
}
