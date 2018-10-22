package questions.leetcode248;

public class StrobogrammaticNumberIII {
    int count;
    char[][] pairs = {{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};

    public int strobogrammaticInRange(String low, String high) {
        count = 0;

        for (int len=low.length(); len <=high.length(); len++) {
            char[] c = new char[len];
            dfs(c, low, high, 0, len-1);
        }
        return count;
    }

    private void dfs(char[] c, String low, String high, int left, int right) {
        if (left > right) {
            String s = new String(c);
            if ((s.length() == low.length() && s.compareTo(low) < 0) ||
                    (s.length() == high.length() && s.compareTo(high) > 0))
                return;
            count++;
            return;
        }
        for (char[] pair: pairs) {
            c[left] = pair[0];
            c[right] = pair[1];

            if (c.length != 1 && c[0] == '0')
                continue;
            if (left == right && pair[0] != pair[1])
                continue;

            dfs(c, low, high, left+1, right-1);
        }
    }
}
