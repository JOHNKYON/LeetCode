package questions.leetcode887;

import java.util.HashMap;
import java.util.Map;

public class SuperEggDrop {
    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    Map<Integer, Integer> memo = new HashMap<>();
    private int dp(int k, int n) {
        if (!memo.containsKey(n*100 + k)) {
            int ans;
            if (n == 0)
                ans = 0;
            else if (k == 1)
                ans = n;
            else {
                int lo = 1, hi = n;
                while (lo + 1 < hi) {
                    int x = lo + (hi - lo) / 2;
                    int t1 = dp(k-1, x-1);
                    int t2 = dp(k, n-x);

                    if (t1 < t2)
                        lo = x;
                    else if (t1 > t2)
                        hi = x;
                    else
                        lo = hi = x;
                }
                ans = 1 + Math.min(Math.max(dp(k-1, lo-1), dp(k, n-lo)),
                        Math.max(dp(k-1, hi-1), dp(k, n-hi)));
            }

            memo.put(n*100 + k, ans);
        }
        return memo.get(n*100 + k);
    }

    public int superEggDrop2(int K, int N) {
        int lo = 1, hi = N;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (f(mi, K, N) < N)
                lo = mi + 1;
            else
                hi = mi;
        }

        return lo;
    }

    public int f(int x, int K, int N) {
        int ans = 0, r = 1;
        for (int i = 1; i <= K; ++i) {
            r *= x-i+1;
            r /= i;
            ans += r;
            if (ans >= N) break;
        }
        return ans;
    }
}
