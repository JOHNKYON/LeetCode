package questions.leetcode121;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {

        int left = 0;
        int right = left + 1;
        int length = prices.length;
        int res = 0;

        while(right < length){
            if (prices[right] <= prices[left]){
                left = right;
                right = left +1;
            } else {
                int temp = prices[right] - prices[left];
                res = (temp > res)? temp : res;
                right++;
            }
        }
        return res;
    }
}
