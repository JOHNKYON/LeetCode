package questions.leetcode464;

import java.util.HashMap;
import java.util.Map;

public class CanIWin {
    private Map<Integer, Boolean> map;
    private boolean[] dp;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal)
            return true;

        int sum = (1 + maxChoosableInteger) * maxChoosableInteger/2;
        if (sum < desiredTotal)
            return false;

        map = new HashMap<>();
        dp = new boolean[maxChoosableInteger + 1];
        return helper(desiredTotal);
    }

    private boolean helper(int desiredTotal) {
        if (desiredTotal <= 0)
            return false;
        int key = format(dp);
        if (!map.containsKey(key)){
            for (int i=1; i<dp.length; i++) {
                if (!dp[i]) {
                    dp[i] = true;
                    if (!helper(desiredTotal - i)) {
                        map.put(key, true);
                        dp[i] = false;
                        return true;
                    }
                    dp[i] = false;
                }
            }
            map.put(key, false);
        }
        return map.get(key);
    }

    private int format(boolean[] dp) {
        int num = 0;
        for (boolean b: dp) {
            num <<= 1;
            if(b) num |= 1;
        }
        return num;
    }
}
