package questions.leetcode833;

import java.util.Arrays;

public class FindAndReplaceinString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int N = S.length();
        int [] match = new int[N];
        Arrays.fill(match, -1);

        for (int i=0; i<indexes.length; i++) {
            int ix = indexes[i];
            if (S.substring(ix, ix+sources[i].length()).equals(sources[i]))
                match[ix] = i;
        }

        StringBuilder ans = new StringBuilder();

        int ix = 0;
        while (ix < N) {
            if (match[ix] == -1)
                ans.append(S.charAt(ix++));
            else {
                ans.append(targets[match[ix]]);
                ix += sources[match[ix]].length();
            }
        }
        return ans.toString();
    }
}
