package questions.leetcode714;

public class BestTimetoBuyandSellStockwithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1)
            return 0;
        int owns = -prices[0];
        int non = 0;
        for (int i=1; i<prices.length; i++) {
            owns = Math.max(owns, non-prices[i]);
            non = Math.max(non, prices[i]+owns-fee);
        }

        return Math.max(owns, non);
    }
}
