package questions.leetcode322;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        minCoins(coins, amount, dp);

        return dp[amount];
    }

    private int minCoins(int[] coins, int amount, int[] dp){
        if (amount < 0 || dp[amount] == -1) return -1;

        if (amount == 0)    return 0;

        if (dp[amount] != 0)  return dp[amount];

        int min = Integer.MAX_VALUE;
        boolean valid = false;
        for (int coin : coins){
            if (coin == 0)
                continue;

            int temp = minCoins(coins, amount-coin, dp);
            if (temp >=0 && temp < min){
                min = temp;
                valid = true;
            }
        }

        if (!valid)
            min = -2;

        dp[amount] = min + 1;
        return min + 1;

    }

    public int coinCHangeIterative(int[] coins, int amount){
        int[] dp = new int[amount+1];

        int curr = 0;
        while (++curr <= amount){
            int min = -1;
            for (int coin : coins){
                if (curr >= coin && dp[curr-coin] != -1){
                    int temp = dp[curr-coin] + 1;
                    min = (min < 0)? temp : (min < temp)? min: temp;
                }
            }
            dp[curr] = min;
        }

        return dp[amount];

    }
}
