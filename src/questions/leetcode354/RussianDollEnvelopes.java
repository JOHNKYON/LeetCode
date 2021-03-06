package questions.leetcode354;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null ||
                envelopes.length == 0 ||
                envelopes[0].length == 0)
            return 0;

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        int n = envelopes.length;
        int[] dp = new int[n];
        int res = 0;

        for (int i=0; i<n; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if (envelopes[i][0] > envelopes[j][0] &&
                        envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], 1+dp[j]);
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public int maxEnvelopes2(int[][] envelopes) {
        if (envelopes == null ||
                envelopes.length == 0 ||
                envelopes[0].length == 0)
            return 0;

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return Integer.compare(b[1], a[1]);
                return Integer.compare(a[0], b[0]);
            }
        });

        int[] dp = new int[envelopes.length];
        int len = 0;

        for (int[] envelope: envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if (index < 0)
                index = -(index + 1);
            dp[index] = envelope[1];
            if (index == len)
                len++;
        }

        return len;
    }
}
