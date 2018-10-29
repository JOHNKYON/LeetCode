package questions.leetcode727;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumWindowSubsequence {
    public String minWindow(String S, String T) {
        if (S == null || S.length() == 0 ||
                S.length() < T.length() || T == null ||
                T.length() == 0)
            return "";

        int n = S.length(), m = T.length();
        int[][] dp = new int[m][n];

        for (int j=0; j<m; j++) {
            int temp = -1;
            for (int i=0; i<n; i++) {
                dp[j][i] = temp;
                // Len 1
                if (j == 0) {
                    if (S.charAt(i) == T.charAt(j)) {
                        temp = Math.max(temp, i);
                        dp[j][i] = temp;
                    }
                } else {
                    if (i - j >= 0) {
                        if (S.charAt(i) == T.charAt(j)) {
                            temp = Math.max(temp, dp[j - 1][i - 1]);
                            dp[j][i] = temp;
                        }
                    }
                }
            }
        }
        int left = 1, right = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            if (dp[m-1][i] != -1) {
                int len = i - dp[m-1][i] + 1;
                if (len < right - left + 1) {
                    left = dp[m-1][i];
                    right = i;
                }
            }
        }
        return (right < Integer.MAX_VALUE)?S.substring(left, right+1): "";
    }

    public String minWindow2(String S, String T) {
        int N = S.length();
        int[] last = new int[26];
        int[][] nxt = new int[N][26];
        Arrays.fill(last, -1);

        for (int i = N - 1; i >= 0; --i) {
            last[S.charAt(i) - 'a'] = i;
            for (int k = 0; k < 26; ++k) {
                nxt[i][k] = last[k];
            }
        }

        List<int[]> windows = new ArrayList();
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == T.charAt(0))
                windows.add(new int[]{i, i});
        }
        for (int j = 1; j < T.length(); ++j) {
            int letterIndex = T.charAt(j) - 'a';
            for (int[] window: windows) {
                if (window[1] < N-1 && nxt[window[1]+1][letterIndex] >= 0) {
                    window[1] = nxt[window[1]+1][letterIndex];
                }
                else {
                    window[0] = window[1] = -1;
                    break;
                }
            }
        }

        int[] ans = {-1, S.length()};
        for (int[] window: windows) {
            if (window[0] == -1) break;
            if (window[1] - window[0] < ans[1] - ans[0]) {
                ans = window;
            }

        }
        return ans[0] >= 0 ? S.substring(ans[0], ans[1] + 1) : "";
    }
}
